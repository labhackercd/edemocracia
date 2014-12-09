package br.gov.camara.edemocracia.portlets.libs;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class Biblioteca {
	private static Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
	private static Log _log = LogFactoryUtil.getLog(Biblioteca.class);

	public static boolean validarEmail(String email) {
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Validacao validarCampos(Long companyId, String nome, String email, String emailValidacao, String senha, String senhaValidacao,
	        Boolean termosB, Long uf, String captcha) {
		List<String> mensagens = new ArrayList<String>();
		Validacao validar = new Validacao(true, mensagens);

		if (StringUtils.isBlank(nome)) {
			mensagens.add("somente-um-nome");
		} else if (nome.trim().length() > 70) {
			mensagens.add("nome-invalido");
		}

		if (StringUtils.isBlank(email)) {
			mensagens.add("infome-email");
		} else if (email.trim().length() > 70) {
			mensagens.add("email-excedido");
		}

		if (StringUtils.isBlank(senha)) {
			mensagens.add("informe-senha");
		} else if (senha.trim().length() > 70) {
			mensagens.add("senha-excedida");
		}

		if (uf == null) {
			mensagens.add("selecione-uf");
		} else {
			// Verifica se o país está correto
			try {
				Region regiao = RegionServiceUtil.getRegion(uf);
				Country pais = CountryServiceUtil.getCountry(regiao.getCountryId());
				if (!"BR".equalsIgnoreCase(pais.getA2()))
					mensagens.add("selecione-uf");
			} catch (SystemException e) {
				throw new RuntimeException(e);
			} catch (PortalException e) {
				mensagens.add("selecione-uf");
			}
		}
		
		if (StringUtils.isBlank(captcha)) {
			validar.setValidar(false);
			mensagens.add("informe-captcha");
		}

		if (!mensagens.isEmpty()) {
			validar.setValidar(false);
			validar.setMensagem(mensagens);
			return validar;
		}

		nome = nome.trim();
		email = email.trim();

		String nomeFinal = retornaUltima(nome);
		if (nomeFinal.equals("")) {
			validar.setValidar(false);
			mensagens.add("somente-um-nome");
		}
		if (!senha.equals(senhaValidacao)) {
			validar.setValidar(false);
			mensagens.add("validacao-senha");
		}
		if (!email.equals(emailValidacao)) {
			validar.setValidar(false);
			mensagens.add("validacao-email");
		} else if (!validarEmail(email)) {
			validar.setValidar(false);
			mensagens.add("email-invalido");
		} else {
			try {
				User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
				if (user != null) {
					validar.setValidar(false);
					mensagens.add("usuario-cadastrado");
				}
			} catch (PortalException e) {
				_log.info("Usuário inexistente");
			} catch (SystemException e) {
				_log.info("Usuário inexistente");
			}
		}
		if (!termosB) {
			validar.setValidar(false);
			mensagens.add("termos-enabled");
		}
		if (uf.equals(new Long(0))) {
			validar.setValidar(false);
			mensagens.add("selecione-uf");
		}

		if (!validarCaptcha(captcha)) {
			validar.setValidar(false);
			mensagens.add("captcha-invalido");
		}

		validar.setMensagem(mensagens);

		return validar;
	}

	public static String retornaUltima(String palavra) {
		String str = palavra;
		StringBuilder palavraFinal = new StringBuilder();
		int index = -1;

		// aqui é procurado um último espaço contido na "String" e o índice
		// desse espaço
		// é armazenado na variável "index"
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				index = i;
		}

		// imprime letra por letra só que começando do (índice + 1) que levará
		// na última palavra
		// Se for so 1 nome retorna S-U-N(sem ultimo nome)
		if (index == -1) {
			return "";
		}
		for (int i = index + 1; i < str.length(); i++)
			palavraFinal.append(str.charAt(i));

		return palavraFinal.toString();
	}

	// Retorna nome do meio
	// if tiver apenas 2 nomes retorna "S-N-M"(Sem nome do meio)
	public static String retornaMeio(String palavra) {
		StringTokenizer nome = new StringTokenizer(palavra);
		StringBuilder meio = new StringBuilder();

		if (nome.countTokens() > 1) {
			if (nome.countTokens() == 2) {
				return "";
			}
			nome.nextToken();
			int qtdPalavras = nome.countTokens() - 1;
			while (nome.hasMoreTokens()) {
				meio.append(nome.nextToken());
				if (nome.hasMoreTokens())
					meio.append(" ");
				if (qtdPalavras == 1)
					break;
				qtdPalavras -= 1;
			}
		} else {
			return "";
		}
		return meio.toString();

	}

	public static String retornaPrimeiro(String palavra) {
		StringTokenizer nome = new StringTokenizer(palavra);
		return nome.nextToken();
	}
	
	public static boolean validarCaptcha(String captcha) {
		String realCaptchaText = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CAPTCHA_TEXT");

		return StringUtils.equals(realCaptchaText, captcha); 
	}

}
