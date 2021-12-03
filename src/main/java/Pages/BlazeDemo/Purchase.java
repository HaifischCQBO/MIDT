package Pages.BlazeDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helpers.Helpers;

public class Purchase {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Purchase(WebDriver driver){  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     *  WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */


    public By input_name = By.id("inputName");
    public By input_address = By.id("address");
    public By input_city = By.id("city");
    public By input_state = By.id("state");
    public By input_zip_code = By.id("zipCode");
    public By select_card_type = By.id("cardType");
    public By input_credit_card_number = By.id("creditCardNumber");
    public By input_month = By.id("creditCardMonth");
    public By input_year = By.id("creditCardYear");
    public By input_name_on_card = By.id("nameOnCard");
    public By input_remember_checkbox = By.id("rememberMe");
    public By button_purchase_flight = By.xpath("//input[@value='Purchase Flight']");

    /**
     * -----------------------------------------------------------------------------------------------------------
     *  Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    public void completarFormulario(String name, String address, String city, String state, String zip_code,
                                    String cardType, String creditCard, String month, String year, String nameCard) {
        helpers.EnviarTexto(input_name, name);
        helpers.EnviarTexto(input_address, address);
        helpers.EnviarTexto(input_city, city);
        helpers.EnviarTexto(input_state, state);
        helpers.EnviarTexto(input_zip_code, zip_code);
        helpers.SelectByText(select_card_type, cardType);
        helpers.EnviarTexto(input_credit_card_number, creditCard);
        helpers.EnviarTexto(input_month, month);
        helpers.EnviarTexto(input_year, year);
        helpers.EnviarTexto(input_name_on_card, nameCard);
        helpers.Click(input_remember_checkbox);
        helpers.Click(button_purchase_flight);
    }


}