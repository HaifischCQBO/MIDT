package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BrowserConfig {
	
	private WebDriver driver;

	Helpers helpers= new Helpers();

	
	public WebDriver setUpBrowser() {
		System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
		if(helpers.getTestParameters("browser").equals("chrome")){
			ChromeOptions chromeOptions = new ChromeOptions();
			if(helpers.getTestParameters("headless").equals("true")){
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("--headless");
			}

		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--test-type=ui");
		chromeOptions.addArguments("--disable-gpu-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		driver.manage().window().maximize();

		return driver;
		}else if(helpers.getTestParameters("browser").equals("firefox")){
			return driver;
		}
		return null;
	}
}
