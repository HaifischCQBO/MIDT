package Pages.BlazeDemo;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Confirmation(WebDriver driver){  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     *  WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By title_confirmation_h1 = By.tagName("h1");





    /**
     * -----------------------------------------------------------------------------------------------------------
     *  Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */


    public String PrintConfirmationMessage(){
        String message = helpers.ObtenerTexto(title_confirmation_h1);
        helpers.Print(message);
        return message;
    }





}
