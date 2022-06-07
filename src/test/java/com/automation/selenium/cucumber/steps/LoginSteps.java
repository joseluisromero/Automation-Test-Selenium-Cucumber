package com.automation.selenium.cucumber.steps;


//import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.automation.selenium.cucumber.runner.pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();


    @Given("^el usuario se encuentra en home cloud systems$")
    public void elUsuarioSeEncuentraEnHomeCloudSystems() {
        loginPage.navigateLogin();
    }

    @When("^Ingresa credenciales click boton aceptar$")
    public void ingresaCredencialesClickBotonAceptar() throws Exception {
        loginPage.clickOnButton();
    }

    @Then("^Redireccionar a pagina de bienvenida$")
    public void redireccionarAPaginaDeBienvenida() throws Exception {
        Assert.assertTrue(loginPage.verificaEncuentraLogeado());
    }

}
