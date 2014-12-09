package br.gov.camara.edemocracia.selenium;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class BatePapoEdemoPostarSair implements Runnable {
	private static final String USUARIO = "userPostarSair";
	private static final String EMAIL = USUARIO + "@teste.br";
	
	public static void main(String[] args) throws Exception {

		for (int cont = 0; cont < 5; cont++) {
			Thread thread = new Thread(new BatePapoEdemoPostarSair(cont));
			thread.start();
		}
	}

	private int cont;

	public BatePapoEdemoPostarSair(int cont) {
		this.cont = cont;
	}

	public void carregarJanela(DesiredCapabilities cap, int cont) throws Exception {
	 // WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new FirefoxDriver(cap);
		driver.get(Configuracoes.getURLDaSala());
	
		try {
			WebElement element = driver.findElement(By.name("nome"));
			element.sendKeys(USUARIO + cont);
			
			element = driver.findElement(By.name("email"));
			element.sendKeys(EMAIL + cont);
			
			element = driver.findElement(By.name("uf"));
			Select Select = new Select(element);
			Select.selectByIndex(3);

			element = driver.findElement(By.name("comando"));
			element.submit();
			Actions act = new Actions(driver);
			act.contextClick();

		} catch (NoSuchElementException e) {
			throw new Exception("aconteceu algum problema inesperado ao tentar entrar no chat", e);
		}
		
		try {
			WebElement element = driver.findElement(By.cssSelector("input#_cdchatroom_WAR_cdchatportlet_msg"));
			for (int i = 0; i < 30; i++) {
				while (!element.isEnabled()) {
					Thread.sleep(1000);
				}
				element.clear();
				element.sendKeys("teste mensagem " + i + " do " + USUARIO);
				element.submit();
				
				Random geradorDeNumerosAleatorios = new Random();
				Number numeroAleatorio = geradorDeNumerosAleatorios.nextInt(3) * 1000;
				Thread.sleep(numeroAleatorio.longValue());
			}
			
			element = driver.findElement(By.cssSelector("a#_cdchatroom_WAR_cdchatportlet_leave"));
			element.click();
			
		
		} catch (NoSuchElementException e) {
			System.out.println("Campo de escrever do chat não foi encontrado.");
			try {
				WebElement element = driver.findElement(By.cssSelector("div.portlet-msg-error"));
				element.getText().trim().toLowerCase().contains("O apelido escolhido já está sendo utilizado nesta sala.".toLowerCase());

			} catch (NoSuchElementException internalE) {}
		}

	}

	public void run() {

		Proxy proxy = new Proxy();
		proxy.setNoProxy(Configuracoes.getNoProxyURL());
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		try {
			carregarJanela(cap, cont);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}