package Pages.MI_DT;

import Helpers.Helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Roles {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Roles(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     * WebElements // WebElements // WebElements // WebElements // WebElements //
     * WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */
    public By botonTrabajador = By.id("btn-trabajador");
    public By botonEmpleador = By.id("btn-empleador");
    public By linkEmpresarioJuridico = By.xpath("//div[@class='title accordion-title' and text()='Empleador Persona Jurídica']");
    public By random_seleccion_empresas = By.xpath("//button[@class = 'ui basic button']");


    public By botonDirigenteSindical = By.id("btn-sindicato");
    public By textoDirigente = By.xpath("//div[@class='title']");
    //public By boton_manual_usuario = By.xpath("//button[@class='ui small button blue basic']");
    public By boton_manual_usuario = By.xpath("//div[@id='roles-right-panel']/div[@class='fadeIn']/div[contains(@class, 'ui')]/button[contains(@class, 'small')]");
    //public By boton_verificador_documentos = By.xpath("//button[@class='ui tiny button blue basic']");
    public By boton_verificador_documentos = By.xpath("//div[@id='roles-right-panel']/div[@class='fadeIn']/div[contains(@class, 'ui')]/button[contains(@class, 'tiny')]");
    public By linkEmpresarioIndividual = By.xpath("//div[@class='title accordion-title' and text()='Empleador Individual']");
    public By boton_persona_natural = By.xpath("//button[@class='ui primary button' and text()='Persona Natural']");
    public By div_error_message = By.xpath("//div[starts-with(@class, 'alert-error')]/div");
    public By button_session_current_user = By.id("sesiondropdown");
    public By div_cerrar_sesion = By.xpath("//div[@aria-labelledby='sesiondropdown']");


    /**
     * -----------------------------------------------------------------------------------------------------------
     * Funciones // Funciones // Funciones // Funciones // Funciones // Funciones //
     * Funciones // Funciones
     * -----------------------------------------------------------------------------------------------------------
     */
    public void clickAndPrintRandomEmpresa(){
        //LISTA DE ELEMENTOS SEGUN BY
        List<WebElement> empresas = helpers.ReturnListOfElements(random_seleccion_empresas);

        helpers.Print("Size:" + empresas.size()+"");
        //0.....SIZE-1
        //GENERAR INDEX ALEATORIO
        int index_random  = helpers.getRandomNumberUsingNextInt(0, empresas.size()-1);

        helpers.Print("index random:" + index_random+"");

        helpers.Click(empresas.get(index_random));
        helpers.Print("La empresa seleccionada es: " + helpers.ObtenerTexto(empresas.get(index_random))+"");
    }

    public boolean CerrarSesion(){
       helpers.Click(button_session_current_user);
       helpers.Click(div_cerrar_sesion);
       return helpers.waitUntilURLIsChangedandContains("welcome");

    }



    public void seleccionPerfilTrabajador() {
        helpers.Click(botonTrabajador);
    }

    public void seleccionPerfilTipoEmpleadorIndividual() {
        helpers.Click(botonEmpleador);
        helpers.Click(linkEmpresarioIndividual);
        helpers.Click(boton_persona_natural);
    }

    public boolean seleccionPerfilTipoEmpleadorJuridico() {
        helpers.Click(botonEmpleador);
        helpers.Click(linkEmpresarioJuridico);
        if(helpers.ComprobarExistencia(div_error_message)){
            return true;
        }else{
            return false;
        }


    }



    public void seleccionPerfilSindicato() {
        helpers.Click(botonDirigenteSindical);
    }

    public String PrintConfirmationMessage(){
        String message = helpers.ObtenerTexto(textoDirigente);
        helpers.Print(message);
        return message;
    }

    public void clickBotonManualUsuario() {
        helpers.Click(boton_manual_usuario);
    }

    public void clickBotonVerficidorDocumentos() {
        helpers.Click(boton_verificador_documentos);
    }
}