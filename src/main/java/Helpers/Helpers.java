package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Helpers {

    private static WebDriver driver; // Instancio un objecto de driver para utilizar
    private static WebDriverWait wait; // Instancio una espera de webdriver
    private WebElement Elemento;

    int seconds = 30;

    public Helpers(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, seconds);
    }

    public Helpers() {

    }

    public String getTestParameters(String key){
        String value =  Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(key);
        Print("El parametro: " + key + " contiene el valor: " + value);

        return value;
    }

    public boolean CompararTexto(String Texto_Esperado, String Texto_Recibido){
        if(Texto_Esperado.equals(Texto_Recibido)) {
            return true;
        }else{
                return false;
            }

    }

    public boolean waitUntilURLIsChangedandContains(String fraction){

        return wait.until(ExpectedConditions.urlContains(fraction));
    }

    public String returnURL() {
        return driver.getCurrentUrl();
    }

    public void goToURL(String destination) {
        driver.get(destination);
    }

    public void Click(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    public void Click(WebElement elemento) {
        elemento.click();
    }

    public void Print(String texto) {
        System.out.println(texto);
    }

    public void EnviarTexto(By by, String Texto) {

        Print("Se envia el texto: " + Texto + " al Objecto: " + by);
        Elemento = driver.findElement(by);
        Elemento.clear();
        Elemento.sendKeys(Texto);
    }

    public boolean ComprobarExistencia(By by){
        if(driver.findElements(by).isEmpty()){
            Print("Elemento "+by+" no existe");
            return false;
        }else{
            Print("Elemento "+by+" si existe");
            return true;
        }
    }
    public void SelectByText(By by, String Texto) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(Texto);
    }

    public String ObtenerTexto(By by) {
        return driver.findElement(by).getText();
    }

    public String ObtenerTexto(WebElement elemento) {
        return elemento.getText();
    }

    public void Pause(int seconds) throws InterruptedException {

        Thread.sleep(seconds * 1000);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public List<WebElement> ReturnListOfElements(By by) {
        return driver.findElements(by);
    }

    public String obtenerCurrentWindow(){
        String current_handle = driver.getWindowHandle();
        Print(current_handle);
        return current_handle;
    }

    public void cambiarUltimaVentana(){


        Set<String> handles = driver.getWindowHandles();
        for(String actual : handles){
            Print("Window's Handle: " + actual);
            driver.switchTo().window(actual);
        }
    }
    public void cambiarVentana(String handle){
        driver.switchTo().window(handle);
    }
}
