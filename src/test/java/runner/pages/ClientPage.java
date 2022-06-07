package runner.pages;

import org.openqa.selenium.WebElement;

public class ClientPage extends BasePage {
    public ClientPage() {
        super(driver);
    }

    public boolean verificaEncuentraModuloVentas() throws Exception {
        String text = getText("/html/body/app-root/app-inicio/div/div[2]/div/div/b");
        try {
            if (text.trim().equals("MÓDULO VENTAS"))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("Error locacion no encontrado " + e.getMessage());
        }

    }

    public void clickOnLinkClient() {
        clickElement("//body/app-root[1]/app-inicio[1]/div[1]/div[1]/div[2]/p-scrollpanel[1]/div[1]/div[1]/div[1]/div[1]/p-panelmenu[1]/div[1]/div[1]/div[1]/a[1]/span[2]");
    }

    public boolean verificaEncuentraClientes() throws Exception {
        String text = getText("//div[contains(text(),'Clientes')]");
        try {
            if (text.trim().equals("Clientes"))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("Error locacion no encontrado " + e.getMessage());
        }

    }

    public void filterClientByIdentification(String identification) {
        clickOnLinkClient();
        findXpath("//thead/tr[2]/th[1]/input[1]").sendKeys(identification);
        if (findXpath("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody").isDisplayed()) {
            clickElement("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody/tr[1]/td[7]/button");
        }
    }

    public void insertDataUpdateClient() {
        WebElement element = findId("txtDireccion");
        String direccion = element.getText() + " Modificada";
        element.clear();
        element.sendKeys(direccion);
    }

    public void butonUpdateClient() {
        findXpath("//*[@id=\"frmDatos\"]/div[2]/div[1]/button").click();
    }

    public boolean messageUpdate() throws Exception {
        String text = getText("/html/body/app-root/p-toast/div");
        try {
            if (text.trim().equals("Registro actualizado."))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("Error locacion no encontrado " + e.getMessage());
        }
    }

    public void clickNewClient() {
        clickOnLinkClient();
        clickElement("//span[contains(text(),'Nuevo')]");
    }

    public void insertNewClient() {
        String cedula = "1311901005";
        String nombres = "Juan P";
        String apellidos = "Perez V";
        String telefono = "088765456";
        String email = "jpperez@gmail.com";
        String direccion = "Vicentina";
        findXpath("//input[@id='txtCedula']").sendKeys(cedula);
        findXpath("//input[@id='txtNombre']").sendKeys(nombres);
        findXpath("//input[@id='txtApellido']").sendKeys(apellidos);
        findXpath("//input[@id='txtTelefono']").sendKeys(telefono);
        findXpath("//input[@id='txtEmail']").sendKeys(email);
        findXpath("//textarea[@id='txtDireccion']").sendKeys(direccion);
    }

    public void butonSaveNewClient() {
        clickElement("//*[@id=\"frmDatos\"]/div[2]/div[1]/button");
    }

    public boolean messageSaveNewClient() throws Exception {
        String text = getText("/html/body/app-root/p-toast/div");
        try {
            if (text.trim().equals("Registro actualizado."))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("Error locacion no encontrado " + e.getMessage());
        }
    }
}
