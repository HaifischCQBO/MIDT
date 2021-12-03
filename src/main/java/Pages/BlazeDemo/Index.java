package Pages.BlazeDemo;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Index {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Index(WebDriver driver){  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     *  WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By select_departure_city = By.name("fromPort");
    public By select_destination_city = By.name("toPort");
    public By input_find_flights_button = By.xpath("//input[@value='Find Flights']");






    /**
     * -----------------------------------------------------------------------------------------------------------
     *  Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */


    public void selectDepartureCity(String City){
        helpers.SelectByText(select_departure_city, City);
    }
    public void selectDestinationCity(String City){
        helpers.SelectByText(select_destination_city, City);
    }
    public void searchFlights(){
        helpers.Click(input_find_flights_button);
    }




}
