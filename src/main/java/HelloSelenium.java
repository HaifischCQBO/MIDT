import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HelloSelenium {

	public static void Imprimir(String texto) {
		System.out.println(texto);
	}

	public static void ejemplo() {
		// AUTOMATIZACION A NIVEL DE NAVEGADOR
		// declarar variable del sistema
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

		// Inicializar el objecto del webdriver
		WebDriver driver = new ChromeDriver();

		// ir a pagina
		driver.get("https://blazedemo.com/");
		// BUSQUEDA DE ELEMENTOS SIMPLE
		WebElement From = driver.findElement(By.xpath("//form[@action='reserve.php']/select"));
		WebElement To = driver.findElement(By.name("toPort"));
		// BUSQUEDA DE ELEMENTOS EN CONTEXTO: SELECT

		Select From_2 = new Select(From);
		Select To_2 = new Select(To);

		Imprimir("DESDE: " + From_2.getFirstSelectedOption().getText());
		Imprimir("HACIA: " + To_2.getFirstSelectedOption().getText());

		WebElement boton_buscar = driver.findElement(By.tagName("input"));
		System.out.println(boton_buscar.getAttribute("value"));

		boton_buscar.click();

		/*
		 * PARA BUSCAR ELEMENTOS BASICOS driver.findElement() //CLASE BY BUSQUEDA
		 * //<input id="id_element"> By.id("id_element"); //<input name="nombre">
		 * By.name("nombre"); //<input class="inputText"> -> Correcto //<input
		 * class="inputText parrafo textobONITO"> -> ClassName no detecta clases
		 * compuestas By.className("inputText"); //<a href="www.google.com">GOOGLE</a>
		 * By.linkText("GOOGLE"); By.partialLinkText("GLE"); By.partialLinkText("GOO");
		 * //<container> ex. </container> By.tagName("container");
		 * 
		 * //BUSQUEDA DE ELEMENTOS AVANZADOS By.cssSelector("input[#name='q']");
		 * 
		 * //TAGNAME[@ATTRIBUTE='X']
		 * //TAGNAME[@color='rojo']/tagname[@color='cafe']/tagname[@color='verde'][3]
		 * //DIV[@color="purpura"]/parent::a[@color='light-green']/ancester::div[@color=
		 * 'red'] By.xpath(null);
		 */

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	public static void main(String[] args) {
		// AUTOMATIZACION A NIVEL DE NAVEGADOR
		// declarar variable del sistema
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");

		// Inicializar el objecto del webdriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// ir a pagina
		driver.get("https://www.dt.gob.cl/");

		
	}
}
