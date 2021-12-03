package Pages.MI_DT;

import Helpers.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    public WebDriver driver; //Declaro Objeto Driver.
    public Helpers helpers;

    public Login(WebDriver driver) {  //Metodo Constructor de la Clase.
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    /**
     * ---------------------------------------------------------------------------------------------------------
     *  WebElements // WebElements // WebElements // WebElements // WebElements // WebElements // WebElements //
     * ---------------------------------------------------------------------------------------------------------
     */

    public By link_mi_dt_site = By.linkText("Mi DT");
    public By iniciar_sesion_clave_unica = By.id("nuevaSesion");
    public By clave_unica_input_name = By.id("uname");
    public By clave_unica_input_password = By.id("pword");
    public By submit_clave_unica = By.id("login-submit");




    /**
     * -----------------------------------------------------------------------------------------------------------
     *  Funciones // Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones //  Funciones
     * -----------------------------------------------------------------------------------------------------------
     */

    @Step("Se procede a entrar a plataforma de MI DT")
    public void goToMIDT(){
        helpers.Click(link_mi_dt_site);

    }
    @Step("Se ingresa a login de Clave unica")
    public boolean iniciarSesionClaveUnica(String username, String password, String host){
        helpers.Click(iniciar_sesion_clave_unica);
        helpers.EnviarTexto(clave_unica_input_name, username);
        helpers.EnviarTexto(clave_unica_input_password, password);
        helpers.Click(submit_clave_unica);
        if(helpers.returnURL().equals("https://"+host+"/roles")) {
            return true;
        }else{
            return false;
        }

    }
}
