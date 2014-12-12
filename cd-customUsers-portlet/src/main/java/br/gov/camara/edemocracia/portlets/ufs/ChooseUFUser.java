/**
 * Copyright (c) 2009-2014 Câmara dos Deputados. Todos os direitos reservados.
 *
 * e-Democracia é um software livre; você pode redistribuí-lo e/ou modificá-lo dentro
 * dos termos da Licença Pública Geral Menor GNU como publicada pela Fundação do 
 * Software Livre (FSF); na versão 2.1 da Licença, ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser  útil, mas SEM NENHUMA GARANTIA;
 * sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR.
 * Veja a Licença Pública Geral Menor GNU para maiores detalhes. 
 */
package br.gov.camara.edemocracia.portlets.ufs;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.persistence.AddressUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class ChooseUFUser extends GenericPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ChooseUFUser.class);


	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		ThemeDisplay td = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = td.getCompanyId();
		User user = null;

		try {

			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));

			String lastPath = httpReq.getParameter("lp");
			if (!Validator.isNull(lastPath)) {
				if (lastPath.equals("/") || lastPath.equals("/home"))
					lastPath = "/principal";
			} else {
				lastPath = "/principal";
			}

			boolean endCompleto = false;
			user = td.getRealUser();
			Contact c = user.getContact();

			List<com.liferay.portal.model.Address> enderecos = AddressLocalServiceUtil
					.getAddresses(companyId,
							"com.liferay.portal.model.Contact",
							c.getContactId());
			if (!enderecos.isEmpty()) {
				long brasilId = CountryServiceUtil.getCountryByA2("BR").getCountryId();
				for (Address address : enderecos) {
					if (address.getRegionId() != 0 && address.getCountryId() == brasilId) {
						endCompleto = true;
						break;
					}
				}
			}

			request.setAttribute("endCompleto", endCompleto);
			request.setAttribute("lp", lastPath);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getPortletContext().getRequestDispatcher("/html/view.jsp")
				.include(request, response);
	}

	@ProcessAction(name = "chooseUF")
	public void chooseUF(ActionRequest req, ActionResponse rsp) {
		ThemeDisplay td = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		String lastPath = ParamUtil.get(req, "lp", "/principal");
		if (!lastPath.startsWith("/"))
			lastPath = "/principal";

		// Só faz alteração se for um usuário autenticado
		if (!td.getUser().isDefaultUser()) {
			long companyId = td.getCompanyId();
			Long uf = Long.parseLong(req.getParameter("uf"));
	
			try {
				User user = td.getRealUser();
				Contact c = user.getContact();
	
				List<com.liferay.portal.model.Address> enderecos = AddressLocalServiceUtil
						.getAddresses(companyId,
								"com.liferay.portal.model.Contact",
								c.getContactId());
	
				long brasilId = CountryServiceUtil.getCountryByA2("BR").getCountryId();
	
				boolean enderecoCompleto = false;
				for (Address address : enderecos) {
					if (address.getRegionId() == 0) {
						address.setRegionId(uf);
						address.setAddressId(address.getAddressId());
	
						address = AddressLocalServiceUtil
								.updateAddress(address);
						enderecoCompleto = true;
						break;
					}
				}
				if (!enderecoCompleto) {
					com.liferay.portal.model.Address address = AddressUtil
							.create(CounterLocalServiceUtil
									.increment(com.liferay.portal.model.Address.class
											.getName()));
					address.setCompanyId(companyId);
					address.setCity("-");
					address.setStreet1("-");
					address.setZip("-");
					address.setPrimary(true);
					address.setMailing(false);
					address.setCountryId(brasilId);
					address.setRegionId(uf);
					address.setUserId(user.getUserId());
					address.setUserName(user.getFullName());
					address.setCreateDate(new Date());
					address.setModifiedDate(new Date());
					address.setTypeId(11000);
					address.setClassPK(user.getContactId());
					address.setClassNameId(PortalUtil.getClassNameId(Contact.class
							.getName()));
	
					address = AddressLocalServiceUtil.addAddress(address);
				}
			
			} catch (SystemException e) {
				_log.error("Erro ao cadastrar UF");
				e.printStackTrace();
			} catch (PortalException e) {
				_log.error("Erro ao cadastrar UF");
				e.printStackTrace();
			}
		}
		try {
			rsp.sendRedirect(lastPath);
		} catch (IOException e) {
			_log.error("Erro ao redirecionar");
			e.printStackTrace();
		}
	}
}
