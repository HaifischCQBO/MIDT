package Tests;

import Helpers.Helpers;
import Pages.MI_DT.Login;
import Pages.MI_DT.Roles;
import baseClass.baseClass;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MI_DT_tests extends baseClass {


    public Helpers IniciarSesionClaveUnica() {
        Helpers helpers = new Helpers(driver);
        helpers.goToURL(helpers.getTestParameters("url"));
        Login login = new Login(driver);
        login.goToMIDT();
        Assert.assertTrue(login.iniciarSesionClaveUnica(helpers.getTestParameters("user"),helpers.getTestParameters("password"),helpers.getTestParameters("host")),"El Login no pudo efectuarse correctamente. ");
        return helpers;
    }


    @Test
    public void Mi_DT_Test_Roles_Trabajador() throws InterruptedException {
        Helpers h = IniciarSesionClaveUnica();
        Roles roles = new Roles(driver);
        roles.seleccionPerfilTrabajador();
        Assert.assertEquals("La URL no es la esperada", "https://"+        h.getTestParameters("host")
        +"/trabajador/home", h.returnURL());
        Assert.assertTrue(roles.CerrarSesion(),"La sesion fue cerrada Incorrectamente o no se completo.");
   }

    @Test
    public void Mi_DT_Test_Roles_Empleador() throws InterruptedException {
        Helpers h = IniciarSesionClaveUnica();
        Roles roles = new Roles(driver);

        Assert.assertFalse( roles.seleccionPerfilTipoEmpleadorJuridico(), "El Usuario no es representante laboral de ninguna empresa.");
        roles.clickAndPrintRandomEmpresa();
        Assert.assertEquals("La URL no es la esperada", "https://"+        h.getTestParameters("host")
        +"/empleador/home", h.returnURL());
        Assert.assertTrue(roles.CerrarSesion(),"La sesion fue cerrada Incorrectamente o no se completo.");

    }

    @Test(description = "Esta es una prueba para validar la forma en que se generan los login en Dirigentes Sindicales")
    @Severity(SeverityLevel.CRITICAL)
    public void Mi_DT_Test_Roles_Dirigente_Sindical() throws InterruptedException {
        IniciarSesionClaveUnica();
        Roles roles = new Roles(driver);

        roles.seleccionPerfilSindicato();
        Assert.assertEquals("La página no se encontro", "Indica que Organización Sindical vas a seleccionar", roles.PrintConfirmationMessage());
        Assert.assertTrue(roles.CerrarSesion(),"La sesion fue cerrada Incorrectamente o no se completo.");

    }

    @Test

    public void Mi_DT_Test_Roles_Manual_De_Usuario() throws InterruptedException {
        Helpers h =IniciarSesionClaveUnica();
        Roles roles = new Roles(driver);
        String current = h.obtenerCurrentWindow();
        roles.clickBotonManualUsuario();
        h.cambiarUltimaVentana();
        Assert.assertEquals("La URL no existe", "https://"+        h.getTestParameters("host")
        +"/static/media/Manual_MiDT.28c4f6c0.pdf",h.returnURL());
        h.cambiarVentana(current);
        Assert.assertTrue(roles.CerrarSesion(),"La sesion fue cerrada Incorrectamente o no se completo.");

    }

    @Test
    public void Mi_DT_Test_Roles_Verificador_De_Documentos() throws InterruptedException {
        Roles roles = new Roles(driver);
        IniciarSesionClaveUnica();
        Assert.assertTrue(roles.CerrarSesion(),"La sesion fue cerrada Incorrectamente o no se completo.");

    }

}