package com.automation.selenium.cucumber.steps;

import com.automation.selenium.cucumber.runner.pages.ClientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ClientSteps {

    ClientPage clientPage = new ClientPage();

    //Scenario 1

    @Given("^el usuario se encuentra en modulo de clientes$")
    public void elUsuarioSeEncuentraEnModuloDeClientes() throws Throwable {
        clientPage.navegarModuloCliente();
    }


    @When("filtramos por identificacion {int}")
    public void filtramosPorIdentificacion(Integer int1) throws Exception {
        clientPage.filterClientByIdentification(String.valueOf(int1));
    }

    @And("^Registramos los datos a modificar$")
    public void registramosLosDatosAModificar() throws Exception {
        clientPage.insertDataUpdateClient();
    }

    @And("^Damos click en el boton guardar$")
    public void damosClickEnElBotonGuardar() {
        clientPage.butonSaveClient();
    }

    @Then("^Se muestra el mensaje de registros actualizado$")
    public void seMuestraElMensajeDeRegistrosActualizado() throws Exception {
        Assert.assertTrue(clientPage.messageClientSave());

    }

    //Scenario 2

    @When("^Registramos los datos del nuevo cliente$")
    public void registramosLosDatosDelNuevoCliente() {
        clientPage.insertNewClient();
    }

    @When("^Damos click en el boton guardar nuevo cliente$")
    public void damosClickEnElBotonGuardarNuevoCliente() {
        clientPage.butonSaveClient();
    }

    @Then("^Se muestra el mensaje de registros creado$")
    public void seMuestraElMensajeDeRegistrosCreado() throws Exception {
        Assert.assertTrue(clientPage.messageClientSave());
    }

}
