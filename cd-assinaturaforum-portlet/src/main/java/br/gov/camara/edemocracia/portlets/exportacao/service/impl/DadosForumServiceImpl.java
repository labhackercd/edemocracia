package br.gov.camara.edemocracia.portlets.exportacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.gov.camara.edemocracia.portlets.exportacao.service.base.DadosForumServiceBaseImpl;
import br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumAdminWrapper;
import br.gov.camara.edemocracia.portlets.exportacao.wrapper.DadosForumWrapper;

import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.persistence.MBCategoryUtil;
import com.liferay.portlet.messageboards.service.persistence.MBMessageUtil;
import com.liferay.portlet.ratings.model.RatingsStats;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;

/**
 * The implementation of the dados forum remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil} to access the dados forum remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author bruno
 * @see br.gov.camara.edemocracia.portlets.exportacao.service.base.DadosForumServiceBaseImpl
 * @see br.gov.camara.edemocracia.portlets.exportacao.service.DadosForumServiceUtil
 */
public class DadosForumServiceImpl extends DadosForumServiceBaseImpl {
	
	/**
	 * Retorna os dados para exportação
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public List<DadosForumWrapper> getDadosForumExportacao(final Long groupId) throws SystemException, PortalException {
		
		List<DadosForumWrapper> dadosRetorno = new ArrayList<DadosForumWrapper>();

		for (Group group : getGroups(groupId)) {
			List<MBCategory> categorias =  MBCategoryUtil.filterFindByGroupId(group.getGroupId());
			if(!categorias.isEmpty()) {
				for(MBCategory categoria : categorias){
					addCategoryMessages(group.getGroupId(), categoria, dadosRetorno);
				}
			}
			
			//Categoria para obter mensagens da raiz do fórum
			MBCategory rootCategory = MBCategoryUtil.create(0l);
			rootCategory.setGroupId(group.getGroupId());
			addCategoryMessages(group.getGroupId(), rootCategory, dadosRetorno);
		}
		
		return dadosRetorno;
	}
	
	/**
	 * Retorna os dados para exportação para administradores
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 * @throws PortalException 
	 */
	public List<DadosForumAdminWrapper> getDadosForumAdminExportacao(final Long groupId) throws SystemException, PortalException {
		
		List<DadosForumAdminWrapper> dadosRetorno = new ArrayList<DadosForumAdminWrapper>();
		
		for (Group group : getGroups(groupId)) {
			List<MBCategory> categorias = MBCategoryUtil.filterFindByGroupId(group.getGroupId());
			if (!categorias.isEmpty()) {
				for (MBCategory categoria : categorias) {
					addCategoryMessagesAdmin(group.getGroupId(), categoria,
							dadosRetorno);
				}
			}
			
			// Categoria para obter mensagens da raiz do fórum
			MBCategory rootCategory = MBCategoryUtil.create(0l);
			rootCategory.setGroupId(group.getGroupId());
			addCategoryMessagesAdmin(group.getGroupId(), rootCategory,dadosRetorno);
		}
		
		return dadosRetorno;
	}
	
	private List<Group> getGroups(long groupId) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(GroupModel.class, PortalClassLoaderUtil.getClassLoader()).addOrder(OrderFactoryUtil.asc("groupId"));
		query.add(RestrictionsFactoryUtil.or(PropertyFactoryUtil.forName("groupId").eq(groupId), PropertyFactoryUtil.forName("parentGroupId").eq(groupId)));
		
		return (List<Group>) GroupLocalServiceUtil.dynamicQuery(query);
	}
	
	private void addCategoryMessages(long groupId ,MBCategory categoria, List<DadosForumWrapper> dadosRetorno) throws SystemException, PortalException {
		
		for(MBMessage mensagem : MBMessageUtil.filterFindByG_C(groupId, categoria.getCategoryId())) {
			DadosForumWrapper dadosForum = new DadosForumWrapper();
			dadosForum.setDataCriacao(mensagem.getCreateDate());
			if(mensagem.getCategoryId() != 0l){
				dadosForum.setEixo(categoria.getName());
				dadosForum.setIdEixo(categoria.getCategoryId());
				dadosForum.setIdEixoPai(categoria.getParentCategoryId());
			}
			dadosForum.setIdFase(categoria.getGroupId());
			dadosForum.setIdMensagem(mensagem.getMessageId());
			dadosForum.setIdMensagemPai(mensagem.getParentMessageId());
			dadosForum.setIdMensagemRaiz(mensagem.getRootMessageId());
			dadosForum.setIdProposta(mensagem.getThreadId());
			if(!mensagem.isAnonymous()) {
				dadosForum.setIdUsuario(mensagem.getUserId());
				dadosForum.setUsuario(mensagem.getUserName());
			}
			dadosForum.setProposta(MBMessageLocalServiceUtil.getMBMessage(mensagem.getRootMessageId()).getSubject());
			dadosForum.setTextoMensagem(mensagem.getBody());
			RatingsStats ratingStats = RatingsStatsLocalServiceUtil.getStats("com.liferay.portlet.messageboards.model.MBMessage", mensagem.getMessageId());
			dadosForum.setPontuacaoAvaliacoes(((Double)ratingStats.getTotalScore()).longValue());
			dadosForum.setTotalAvaliacoes(((Integer)ratingStats.getTotalEntries()).longValue());
			dadosRetorno.add(dadosForum);
		}
	}
	
	private void addCategoryMessagesAdmin(long groupId ,MBCategory categoria, List<DadosForumAdminWrapper> dadosRetorno) throws SystemException, PortalException {
		
		for(MBMessage mensagem : MBMessageUtil.filterFindByG_C(groupId, categoria.getCategoryId())) {
			DadosForumAdminWrapper dadosForumAdmin = new DadosForumAdminWrapper();
			dadosForumAdmin.setDataCriacao(mensagem.getCreateDate());
			if(mensagem.getCategoryId() != 0l){
				dadosForumAdmin.setEixo(categoria.getName());
				dadosForumAdmin.setIdEixo(categoria.getCategoryId());
				dadosForumAdmin.setIdEixoPai(categoria.getParentCategoryId());
			}
			dadosForumAdmin.setIdFase(categoria.getGroupId());
			dadosForumAdmin.setIdMensagem(mensagem.getMessageId());
			dadosForumAdmin.setIdMensagemPai(mensagem.getParentMessageId());
			dadosForumAdmin.setIdMensagemRaiz(mensagem.getRootMessageId());
			dadosForumAdmin.setIdProposta(mensagem.getThreadId());
			if(!mensagem.isAnonymous()) {
				dadosForumAdmin.setIdUsuario(mensagem.getUserId());
				dadosForumAdmin.setUsuario(mensagem.getUserName());
				try {
					User user = UserLocalServiceUtil.getUser(mensagem.getUserId());
					dadosForumAdmin.setEmail(user.getEmailAddress());
					dadosForumAdmin.setUf(getUserUF(user));
				} catch (NoSuchUserException e){
					//Ignore
				}
				
			}
			dadosForumAdmin.setProposta(MBMessageLocalServiceUtil.getMBMessage(mensagem.getRootMessageId()).getSubject());
			dadosForumAdmin.setTextoMensagem(mensagem.getBody());
			RatingsStats ratingStats = RatingsStatsLocalServiceUtil.getStats("com.liferay.portlet.messageboards.model.MBMessage", mensagem.getMessageId());
			dadosForumAdmin.setPontuacaoAvaliacoes(((Double)ratingStats.getTotalScore()).longValue());
			dadosForumAdmin.setTotalAvaliacoes(((Integer)ratingStats.getTotalEntries()).longValue());
			dadosRetorno.add(dadosForumAdmin);
		}
		
	}
	
	private String getUserUF(User user) throws SystemException, PortalException {
		List<Address> listAddress = AddressLocalServiceUtil.getAddresses(user.getCompanyId(), Contact.class.getName(), user.getContactId());
		Address principalAddress = null;
		
		if(listAddress.size() == 1){
			principalAddress = listAddress.get(0);
			
		} else if (listAddress.size() > 1) {
			for(Address address : listAddress) {
				if(address.isPrimary()){
					principalAddress = address;
				}
			}
			if(principalAddress == null){
				principalAddress = listAddress.get(0);
			}
		
		} else {
			return null;
		}
		
		try {
			return RegionServiceUtil.getRegion(principalAddress.getRegionId()).getName();
		} catch (PortalException e) {
			if(e instanceof NoSuchRegionException){
				return null;
			} else {
				throw new PortalException(e.getCause());
			}
		}
	}
}
