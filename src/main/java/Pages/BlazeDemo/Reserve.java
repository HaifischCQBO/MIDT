package Pages.BlazeDemo;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Reserve {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Reserve(WebDriver driver){  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     *  WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By form_choose_flight = By.tagName("tr");
    public By button_choose_flight = By.xpath("//tr/td/input[@value='Choose This Flight']");
    public By hidden_flight_input = By.name("flight");
    public By hidden_price_input = By.name("price");
    public By hidden_airline_input = By.name("airline");
    public By hidden_fromPort_input = By.name("fromPort");
    public By hidden_toPort_input = By.name("toPort");


    /**
     * -----------------------------------------------------------------------------------------------------------
     *  Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    public void PrintFlightDataFromElement(String data_header, List<WebElement> vuelos, int index, By by){

        helpers.Print(data_header +" " +
                vuelos.get(index)
                        .findElement(by)
                            .getAttribute("value")
        );
    }

    public void clickAndPrintRandomFlight(){
        //LISTA DE ELEMENTOS SEGUN BY
      List<WebElement> flights = helpers.ReturnListOfElements(form_choose_flight);
      helpers.Print("Size:" + flights.size()+"");
      //0.....SIZE-1
      //GENERAR INDEX ALEATORIO
      int index_random  = helpers.getRandomNumberUsingNextInt(1, flights.size()-1);

        helpers.Print("Random Index:" + index_random+"");
          PrintFlightDataFromElement("Vuelo: ", flights, index_random, hidden_flight_input);
          PrintFlightDataFromElement("Precio: ", flights, index_random, hidden_price_input);
          PrintFlightDataFromElement("Aerolinea: ", flights, index_random, hidden_airline_input);
          PrintFlightDataFromElement("Origen: ", flights, index_random, hidden_fromPort_input);
          PrintFlightDataFromElement("Destino: ", flights, index_random, hidden_toPort_input);

      helpers.Click(flights.get(index_random).findElement(button_choose_flight));
    }







}
