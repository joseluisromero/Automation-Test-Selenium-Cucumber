package steps;


//import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runner.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @Given("el usuario se encuentra en home")
    public void el_usuario_se_encuentra_en_home() {
        loginPage.navigateLogin();
    }

    @When("Ingresa las credenciales click aceptar")
    public void ingresa_las_credenciales_click_aceptar() {
        loginPage.clickOnButton();
    }

    @Then("Redireccionar a pagina de bienvenida")
    public void redireccionar_a_pagina_de_bienvenida() throws Exception {
        Assert.assertTrue(loginPage.verificaEncuentraLogeado());
    }

}
