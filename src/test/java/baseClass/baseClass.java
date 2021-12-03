package baseClass;


import org.openqa.selenium.WebDriver;

import Helpers.BrowserConfig;
import Helpers.Helpers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseClass {
	
	public WebDriver driver;
	Helpers helpers = new Helpers();

	//FIXTURES
	
	//BEFORE: ANTES DE CADA PRUEBA
	@BeforeMethod
	public void setUp() {
		BrowserConfig browserConfig = new BrowserConfig();
		this.driver =browserConfig.setUpBrowser();
		System.out.println("Setup Pruebas");
	}
	//AFTER: DESPUES DE CADA PRUEBA
	@AfterMethod
	public void endTest() {

		System.out.println("Fin de pruebas");
		driver.quit();
	}
	
	
}
