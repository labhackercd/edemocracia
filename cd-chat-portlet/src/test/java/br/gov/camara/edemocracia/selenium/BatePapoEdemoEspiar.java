package br.gov.camara.edemocracia.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BatePapoEdemoEspiar implements Runnable{

	public static void main(String[] args) throws Exception {

		for (int cont = 0; cont < 10; cont++) {
			Thread thread = new Thread(new BatePapoEdemoEspiar());
			thread.start();
		}

	}

	public void carregarJanela(DesiredCapabilities cap) throws Exception {
		WebDriver driver = new FirefoxDriver(cap);
//		 WebDriver driver = new HtmlUnitDriver();
         driver.get(Configuracoes.getURLDaSala());

		try {
			WebElement element = driver.findElement(By.cssSelector(".espiar a"));
			element.click();
			Actions act = new Actions(driver);
			act.contextClick();

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
			carregarJanela(cap);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}