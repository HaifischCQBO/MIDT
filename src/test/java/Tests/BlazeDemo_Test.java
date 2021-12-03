package Tests;

import Helpers.Helpers;
import Pages.BlazeDemo.Confirmation;
import Pages.BlazeDemo.Index;
import Pages.BlazeDemo.Purchase;
import Pages.BlazeDemo.Reserve;
import baseClass.baseClass;
import org.junit.Assert;
import org.junit.Test;

public class BlazeDemo_Test extends baseClass {


    public void BlazeDemo_Flow() throws InterruptedException {

        Helpers helpers = new Helpers(driver);
        Index index = new Index(driver);

        //INDEX
        helpers.goToURL("https://blazedemo.com");
        //Choose your departure city
        index.selectDepartureCity("San Diego");
        //Choose your destination city
        index.selectDestinationCity("Dublin");
        //Select Find Flights
        index.searchFlights();

        //RESERVE
        Reserve reserve = new Reserve(driver);
        //Click and Print information on Specific Flight
        reserve.clickAndPrintRandomFlight();

        //PURCHASE
        Purchase purchase = new Purchase(driver);

        purchase.completarFormulario("QA", "testing_adress", "Testing City", "Testing State", "1542654",
                "American Express", "555458774512546", "99999", "55555", "Julio Cesar");

        //CONFIRMATION
        Confirmation confirmation = new Confirmation(driver);
        //Print confirmation message for succesfull purchase -> Thank you for your purchase today!
        Assert.assertEquals("LA COMPRA NO SE REALIZO DE FORMA EXITOSA","Thank you for your purchase today!", confirmation.PrintConfirmationMessage());

        helpers.Pause(5);


    }

}
