package com.automation.selenium.cucumber.runner.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ClientPage extends BasePage {

    public ClientPage() {
        super(driver);
    }

    public void navegarModuloCliente() throws NoSuchElementException {
        try {
            navigateTo("http://ecloud-systems.com/vlip-conta-login-web/");
            findXpath("/html/body/app-root/app-login/div/div[2]/form/div[1]/div/div[1]/input").sendKeys("1713747903");
            findXpath("/html/body/app-root/app-login/div/div[2]/form/div[2]/div/div[1]/input").sendKeys("maferkitty2019");
            clickElement("/html/body/app-root/app-login/div/div[2]/form/button/span");
            clickTagVentas();
            clickOnLinkClient();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void clickTagVentas() {
        try {
            clickElement("/html/body/app-root/app-dashboard/div/div[2]/div/app-modulos/div/div/div[6]");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void clickOnLinkClient() {
        try {
            clickElement("//body/app-root[1]/app-inicio[1]/div[1]/div[1]/div[2]/p-scrollpanel[1]/div[1]/div[1]/div[1]/div[1]/p-panelmenu[1]/div[1]/div[1]/div[1]/a[1]/span[2]");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public boolean verificaEncuentraClientes() {

        try {
            String text = getText("//div[contains(text(),'Clientes')]");
            if (text.trim().equals("Clientes"))
                return true;
            else
                return false;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void filterClientByIdentification(String identification) throws NoSuchElementException {
        try {
            findXpath("//thead/tr[2]/th[1]/input[1]").sendKeys(identification);
            if (findXpath("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody").isDisplayed()) {
                clickElement("//*[@id=\"tblListaCliente\"]/div/div[2]/table/tbody/tr[1]/td[7]/button");
            }
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void insertDataUpdateClient() {
        try {
            WebElement element = findId("txtDireccion");
            String direccion = element.getText() + " Modificada desde selenium test";
            element.clear();
            element.sendKeys(direccion);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void clickNewClient() {
        try {
            clickElement("//body/app-root[1]/app-inicio[1]/div[1]/div[2]/div[1]/app-lista-cliente[1]/p-panel[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void insertNewClient() {
        try {
            clickNewClient();
            String cedula = "1311902005";
            String nombres = "Juan P2";
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
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public void butonSaveClient() {
        try {
            clickElement("//*[@id=\"frmDatos\"]/div[2]/div[1]/button");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }

    public boolean messageClientSave() throws NoSuchElementException {
        String text = getText("/html/body/app-root/p-toast/div");
        try {
            if (text.trim().equals("Registro actualizado."))
                return true;
            else
                return false;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Error: No se encontro el localizador " + e.getMessage());
        }
    }
}
