package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import runner.pages.ClientPage;
import runner.pages.LoginPage;

public class ClientSteps {

    LoginPage loginPage = new LoginPage();
    ClientPage clientPage = new ClientPage();

    //Scenario 1
    @Given("^el usuario se encuentra en modulo de clientes$")
    public void el_usuario_se_encuentra_en_modulo_de_clientes() throws Throwable {
        loginPage.loginToNavigateClient();
        Assert.assertTrue(clientPage.verificaEncuentraModuloVentas());
    }


    @When("^click en el modulo de ventas y redirige a clintes$")
    public void click_en_el_modulo_de_ventas_y_redirige_a_clintes() throws Throwable {
        clientPage.clickOnLinkClient();
    }

    @Then("^muestra pantalla de clientes$")
    public void muestra_pantalla_de_clientes() throws Throwable {

        Assert.assertTrue(clientPage.verificaEncuentraClientes());
    }

    //Scenario 2
    @Given("Estando en la pagina de clientes filtramos por identificacion {int}")
    public void estandoEnLaPaginaDeClientesFiltramosPorIdentificacion(Integer int1) throws Exception {
        loginPage.loginToNavigateClient();
        clientPage.filterClientByIdentification(String.valueOf(int1));
    }

    @When("Registramos los datos a modificar")
    public void registramosLosDatosAModificar() throws Exception {
        clientPage.insertDataUpdateClient();
    }

    @When("Damos click en el boton guardar")
    public void damosClickEnElBotonGuardar() {
        clientPage.butonUpdateClient();
    }

    @Then("Se muestra el mensaje de registros actualizado")
    public void seMuestraElMensajeDeRegistrosActualizado() throws Exception {
        Assert.assertTrue(clientPage.messageUpdate());
    }

    //Scenario 3
    @Given("Estando en la pagina de clientes")
    public void estandoEnLaPaginaDeClientes() throws Exception {
        loginPage.loginToNavigateClient();
        clientPage.clickNewClient();
    }

    @When("Registramos los datos del nuevo cliente")
    public void registramosLosDatosDelNuevoClienteJuanPerezJperezGmailComDireccion() {
        clientPage.insertNewClient();
    }

    @When("Damos click en el boton guardar nuevo cliente")
    public void damosClickEnElBotonGuardarNuevoCliente() {
        clientPage.butonSaveNewClient();
    }

    @Then("Se muestra el mensaje de registros creado")
    public void seMuestraElMensajeDeRegistrosCreado() throws Exception {
        Assert.assertTrue(clientPage.messageSaveNewClient());
    }

}
