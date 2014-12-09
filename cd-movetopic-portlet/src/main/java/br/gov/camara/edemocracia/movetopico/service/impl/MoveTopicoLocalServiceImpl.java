package br.gov.camara.edemocracia.movetopico.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.gov.camara.edemocracia.movetopico.model.InfoMoverTopico;
import br.gov.camara.edemocracia.movetopico.model.Topico;
import br.gov.camara.edemocracia.movetopico.service.base.MoveTopicoLocalServiceBaseImpl;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;
import com.liferay.portlet.messageboards.service.persistence.MBMessageUtil;
import com.liferay.portlet.messageboards.service.persistence.MBThreadUtil;

/**
 * The implementation of the move topico local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalService}
 * interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil}
 * to access the move topico local service.
 * </p>
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ricardo Lima
 * @see br.gov.camara.edemocracia.movetopico.service.base.MoveTopicoLocalServiceBaseImpl
 * @see br.gov.camara.edemocracia.movetopico.service.MoveTopicoLocalServiceUtil
 */
public class MoveTopicoLocalServiceImpl extends MoveTopicoLocalServiceBaseImpl {
	public List<Topico> getTopicosPorComunidadeEForum(long idComunidade,
			long idForum) {
		List<Topico> resultado = Collections.emptyList();

		try {
			List<MBThread> resultadoParcial = MBThreadUtil.findByG_C(
					idComunidade, idForum);
			resultado = Lists.newArrayList(Iterables.transform(Iterables
					.filter(resultadoParcial, new Predicate<MBThread>() {
						@Override
						public boolean apply(MBThread input) {
							boolean result = false;
							try {
								result = !LockLocalServiceUtil.isLocked(
										MBThread.class.getName(),
										input.getThreadId());
							} catch (SystemException e) {
								e.printStackTrace();
							}
							return result;
						}
					}), new Function<MBThread, Topico>() {

				@Override
				public Topico apply(MBThread input) {
					String assunto = "(sem assunto)";
					try {
						MBMessage mensagemRaiz = MBMessageLocalServiceUtil
								.getMBMessage(input.getRootMessageId());
						String assuntoMensagem = mensagemRaiz.getSubject();
						if (assuntoMensagem != null
								&& !assuntoMensagem.isEmpty()) {
							assunto = assuntoMensagem;
						}
					} catch (PortalException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
					return new Topico(input.getThreadId(), assunto);
				}
			}));
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public List<MBCategory> getForunsComunidade(long idComunidade) {
		List<MBCategory> resultado = Collections.emptyList();
		try {
			resultado = MBCategoryLocalServiceUtil.getCategories(idComunidade);

		} catch (SystemException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public List<Group> getComunidadesComPermissaoParaMover(long idUsuario,
			final long idComunidadeOrigem) {
		List<Group> resultado = Collections.emptyList();
		try {
			final Group comunidadeOrigem = GroupLocalServiceUtil
					.getGroup(idComunidadeOrigem);
			User usuario = UserLocalServiceUtil.getUser(idUsuario);
			final PermissionChecker verificador = PermissionCheckerFactoryUtil
					.create(usuario, true);
			List<Group> gruposUsuario = GroupLocalServiceUtil
					.getUserGroups(idUsuario);
			resultado = Lists.newArrayList(Iterables.filter(gruposUsuario,
					new Predicate<Group>() {

						@Override
						public boolean apply(Group grupo) {

							return grupo.isCommunity()
									&& idComunidadeOrigem != grupo.getGroupId()
									&& grupo.getCompanyId() == comunidadeOrigem
											.getCompanyId()
									&& verificador.hasPermission(
											grupo.getGroupId(),
											"com.liferay.portlet.messageboards",
											grupo.getGroupId(),
											ActionKeys.MOVE_THREAD);
						}
					}));

		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public void moveTopico(InfoMoverTopico info) throws PortalException,
			SystemException {
		MBThread topico = MBThreadLocalServiceUtil.getMBThread(info
				.getIdTopico());
		MBMessage mensagemRaizOriginal = MBMessageLocalServiceUtil
				.getMBMessage(topico.getRootMessageId());
		List<MBMessage> mensagens = MBMessageUtil.filterFindByG_C_T(
				info.getIdComunidadeOrigem(), info.getIdForumOrigem(),
				info.getIdTopico());
		Group comunidadeDestino = GroupLocalServiceUtil.getGroup(info
				.getIdComunidadeDestino());
		Indexer indexadorMensagens = IndexerRegistryUtil
				.getIndexer(MBMessage.class);

		topico.setCategoryId(info.getIdForumDestino());
		topico.setGroupId(info.getIdComunidadeDestino());
		MBThreadLocalServiceUtil.updateMBThread(topico, true);

		int msgCount = 0;
		for (MBMessage mensagem : mensagens) {
			msgCount++;

			mensagem.setGroupId(info.getIdComunidadeDestino());
			mensagem.setCategoryId(info.getIdForumDestino());
			mensagem.setThreadId(info.getIdTopico());
			MBMessageLocalServiceUtil.updateMBMessage(mensagem, true);
			resourceLocalService.addResources(comunidadeDestino.getCompanyId(),
					comunidadeDestino.getGroupId(), info.getIdUsuario(),
					MBMessage.class.getName(), mensagem.getMessageId(), false,
					true, true);
			indexadorMensagens.reindex(mensagem);
		}

		MBCategory forumDestino = MBCategoryLocalServiceUtil.getCategory(info
				.getIdForumDestino());
		forumDestino.setThreadCount(forumDestino.getThreadCount() + 1);
		forumDestino.setMessageCount(forumDestino.getMessageCount() + msgCount);
		MBCategoryLocalServiceUtil.updateMBCategory(forumDestino, true);

		long idmensagemRaizAtual = counterLocalService
				.increment(MBMessage.class.getName());
		long idtopicoAtual = counterLocalService.increment(MBThread.class
				.getName());
		Date now = new Date();
		User user = UserLocalServiceUtil.getUser(info.getIdUsuario());
		String userName = user.getFullName();
		String userUUID = user.getUserUuid();
		MBMessage mensagemRaizAtual = MBMessageLocalServiceUtil
				.createMBMessage(idmensagemRaizAtual);
		MBThread topicoAtual = MBThreadLocalServiceUtil
				.createMBThread(idtopicoAtual);
		mensagemRaizAtual.setCompanyId(mensagemRaizOriginal.getCompanyId());
		mensagemRaizAtual.setGroupId(info.getIdComunidadeOrigem());
		mensagemRaizAtual.setCategoryId(info.getIdForumOrigem());
		mensagemRaizAtual.setCreateDate(now);
		mensagemRaizAtual.setNew(true);
		mensagemRaizAtual.setBody("Esta mensagem foi movida para o fórum [b]"
				+ info.getNomeForumDestino() + "[/b] da comunidade [url='"
				+ info.getUrlComunidadeDestino() + "']"
				+ info.getNomeComunidadeDestino() + "[/url]");
		mensagemRaizAtual.setSubject(mensagemRaizOriginal.getSubject());
		mensagemRaizAtual.setClassNameId(0);
		mensagemRaizAtual.setClassPK(0);
		mensagemRaizAtual.setAnonymous(false);
		mensagemRaizAtual.setAttachments(false);
		mensagemRaizAtual.setParentMessageId(0);
		mensagemRaizAtual.setRootMessageId(idmensagemRaizAtual);
		mensagemRaizAtual.setStatus(0);
		mensagemRaizAtual.setStatusDate(now);
		mensagemRaizAtual.setStatusByUserId(info.getIdUsuario());
		mensagemRaizAtual.setStatusByUserName(userName);
		mensagemRaizAtual.setStatusByUserUuid(userUUID);
		mensagemRaizAtual.setModifiedDate(now);
		mensagemRaizAtual.setThreadId(idtopicoAtual);
		mensagemRaizAtual.setUserId(info.getIdUsuario());
		mensagemRaizAtual.setUserName(userName);
		mensagemRaizAtual.setUserUuid(userUUID);

		topicoAtual.setGroupId(info.getIdComunidadeOrigem());
		topicoAtual.setCategoryId(info.getIdForumOrigem());
		topicoAtual.setMessageCount(1);
		topicoAtual.setNew(true);
		topicoAtual.setRootMessageId(idmensagemRaizAtual);
		topicoAtual.setStatus(0);
		topicoAtual.setStatusByUserId(info.getIdUsuario());
		topicoAtual.setStatusDate(now);
		topicoAtual.setStatusByUserName(userName);
		topicoAtual.setStatusByUserUuid(userUUID);
		topicoAtual.setLastPostDate(now);
		topicoAtual.setLastPostByUserId(info.getIdUsuario());
		topicoAtual.setLastPostByUserUuid(userUUID);

		MBMessageLocalServiceUtil.updateMBMessage(mensagemRaizAtual, true);
		MBThreadLocalServiceUtil.updateMBThread(topicoAtual, true);
		MBThreadServiceUtil.lockThread(idtopicoAtual);

	}

}
