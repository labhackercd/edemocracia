package br.gov.camara.edemocracia.hook.servicewrapper;

import java.io.InputStream;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;

public class MBMessageLocalServiceImplWrapper extends MBMessageLocalServiceWrapper {

	/**
	 * Utilizada para marcar as postagens dos usuários que são deputados
	 * Adicionada como uma {@link AssetTag}
	 */
	private final static String TAG_DEPUTADO = "dep.";

	public MBMessageLocalServiceImplWrapper(MBMessageLocalService mbMessageLocalService) {
		super(mbMessageLocalService);
	}

	@Override
	public MBMessage addMessage(long userId, String userName, long groupId, long categoryId, long threadId, long parentMessageId, String subject, String body,
	        String format, List<ObjectValuePair<String, InputStream>> inputStreamOVPs, boolean anonymous, double priority, boolean allowPingbacks,
	        ServiceContext serviceContext) throws PortalException, SystemException {

		final boolean usuarioDeputado = checarSeUsuarioEDeputado(serviceContext.getUserId());

		if (usuarioDeputado) {
			adicionarTagDeputado(serviceContext);
		} else {
			removerTagDeputadoSeExistir(serviceContext);
		}

		return super.addMessage(userId, userName, groupId, categoryId, threadId, parentMessageId, subject, body, format, inputStreamOVPs,
		        anonymous, priority, allowPingbacks, serviceContext);
	}

	@Override
	public MBMessage addMessage(long userId, String userName, long groupId, long categoryId, String subject, String body, String format,
	        List<ObjectValuePair<String, InputStream>> inputStreamOVPs, boolean anonymous, double priority, boolean allowPingbacks,
	        ServiceContext serviceContext) throws PortalException, SystemException {

		final boolean usuarioDeputado = checarSeUsuarioEDeputado(serviceContext.getUserId());

		if (usuarioDeputado) {
			adicionarTagDeputado(serviceContext);
		} else {
			removerTagDeputadoSeExistir(serviceContext);
		}

		return super.addMessage(userId, userName, groupId, categoryId, subject, body, format, inputStreamOVPs, anonymous, priority,
		        allowPingbacks, serviceContext);
	}

	@Override
	public MBMessage updateMessage(long userId, long messageId, String subject, String body, List<ObjectValuePair<String, InputStream>> inputStreamOVPs,
	        List<String> existingFiles, double priority, boolean allowPingbacks, ServiceContext serviceContext) throws PortalException, SystemException {

		boolean usuarioAtualDeputado = checarSeUsuarioEDeputado(serviceContext.getUserId());
		
		if (usuarioAtualDeputado) {
			adicionarTagDeputado(serviceContext);
			

		} else {

			long userOwnerId = super.getMBMessage(messageId).getUserId();

			boolean usuarioDonoDaMensagemEDeputado = checarSeUsuarioEDeputado(userOwnerId);

			if (usuarioDonoDaMensagemEDeputado) {
				adicionarTagDeputado(serviceContext);
				
			} else {
				removerTagDeputadoSeExistir(serviceContext);
			}

		}

		return super.updateMessage(userId, messageId, subject, body, inputStreamOVPs, existingFiles, priority, allowPingbacks, serviceContext);
	}

	private boolean checarSeUsuarioEDeputado(long userId) throws PortalException, SystemException {
		User user = UserLocalServiceUtil.getUser(userId);
		String email = user.getEmailAddress();

		return email.startsWith("dep.") && (email.endsWith("camara.gov.br") || email.endsWith("camara.leg.br"));
	}

	/**
	 * Adiciona a tag de marcação de postagens de deputado no serviceContext
	 * 
	 * Se já existir, não adiciona nada
	 * 
	 * @param serviceContext
	 */
	private void adicionarTagDeputado(ServiceContext serviceContext) {
		String[] tagsCadastradas = serviceContext.getAssetTagNames();

		// Respostas rápidas não permitem marcação de tags. Logo o valor da
		// lista tagsCadastradas será null

		if (tagsCadastradas == null) {
			tagsCadastradas = new String[1];
			tagsCadastradas[0] = TAG_DEPUTADO;

			serviceContext.setAssetTagNames(tagsCadastradas);

			return;
		}

		int tamanhoDaNovaLista = tagsCadastradas.length + 1;
		String[] tagCadastradasComTagDeputado = new String[tamanhoDaNovaLista];

		boolean existeTagDeputado = false;
		for (int i = 0; i < tagsCadastradas.length; i++) {
			String tag = tagsCadastradas[i];

			if (tag.equalsIgnoreCase(TAG_DEPUTADO)) {
				existeTagDeputado = true;
				break;

			} else {
				tagCadastradasComTagDeputado[i] = tag;
			}
		}

		if (!existeTagDeputado) {
			// Adicionando tag deputado junto com as outras tags cadastradas
			tagCadastradasComTagDeputado[tamanhoDaNovaLista - 1] = TAG_DEPUTADO;
			serviceContext.setAssetTagNames(tagCadastradasComTagDeputado);

		} else {
			serviceContext.setAssetTagNames(tagsCadastradas);
		}

	}

	private void removerTagDeputadoSeExistir(ServiceContext serviceContext) {
		String[] tagsCadastradas = serviceContext.getAssetTagNames();

		if (tagsCadastradas == null) {
			return;
		}

		boolean existeTagDeputado = false;
		for (int i = 0; i < tagsCadastradas.length; i++) {
			String tag = tagsCadastradas[i];

			if (tag.equalsIgnoreCase(TAG_DEPUTADO)) {
				existeTagDeputado = true;
				break;
			}
		}

		if (existeTagDeputado) {
			String[] tagCadastradasSemTagDeputado = new String[tagsCadastradas.length - 1];

			for (int i = 0; i < tagsCadastradas.length; i++) {
				String tag = tagsCadastradas[i];

				if (!tag.equalsIgnoreCase(TAG_DEPUTADO)) {
					tagCadastradasSemTagDeputado[i] = tag;
				}
			}

			serviceContext.setAssetTagNames(tagCadastradasSemTagDeputado);
		}

	}
}
