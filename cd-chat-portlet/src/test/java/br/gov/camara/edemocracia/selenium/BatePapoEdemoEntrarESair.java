package br.gov.camara.edemocracia.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class BatePapoEdemoEntrarESair implements Runnable{
	private static final String USUARIO = "userEntrarESair";
	private static final String EMAIL = USUARIO + "@teste.br";

	public static void main(String[] args) throws Exception {

		for (int cont = 0; cont < 100; cont++) {
			Thread thread = new Thread(new BatePapoEdemoEntrarESair(cont));
			thread.start();
		}

	}

	private int cont;

	public BatePapoEdemoEntrarESair(int cont) {
		this.cont = cont;
	}

	public void carregarJanela(DesiredCapabilities cap, int cont) throws Exception {
//		WebDriver driver = new FirefoxDriver(cap);
		 WebDriver driver = new HtmlUnitDriver();
         driver.get(Configuracoes.getURLDaSala());

		try {
			WebElement element = driver.findElement(By.name("nome"));
			element.sendKeys(USUARIO + cont);
			element = driver.findElement(By.name("email"));
			element.sendKeys(EMAIL + cont);
			element = driver.findElement(By.name("uf"));
			// element.sendKeys();

			Select Select = new Select(element);
			Select.selectByIndex(3);

			element = driver.findElement(By.name("comando"));
			element.submit();
			Actions act = new Actions(driver);
			act.contextClick();

		    Thread.sleep(20000);

			element = driver.findElement(By.cssSelector("a#_cdchatroom_WAR_cdchatportlet_leave"));
			element.click();
			
		} catch (NoSuchElementException e) {
			throw new Exception("aconteceu algum problema inesperado ao tentar entrar no chat", e);
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