package com.automation.selenium.cucumber.runner.pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage() {
        super(driver);
    }

    public void navigateLogin() {
        navigateTo("http://ecloud-systems.com/vlip-conta-login-web/");
    }

    public void clickOnButton() throws Exception {
        try {
            findXpath("/html/body/app-root/app-login/div/div[2]/form/div[1]/div/div[1]/input").sendKeys("1713747903");
            findXpath("/html/body/app-root/app-login/div/div[2]/form/div[2]/div/div[1]/input").sendKeys("maferkitty2019");
            clickElement("/html/body/app-root/app-login/div/div[2]/form/button/span");
        } catch (Exception e) {
            throw new Exception("Error: localizador no encontrado " + e.getMessage());
        }
    }

    public boolean verificaEncuentraLogeado() throws Exception {
        try {
            WebElement element = findXpath("/html/body/app-root/app-dashboard/div/div[2]/div/app-modulos/div/div/div[6]/div/div");
            if (element.isDisplayed()
                    && element.getText().trim().equals("Módulo para el registro de ventas."))
                return true;
            else
                return false;
        } catch (Exception e) {
            throw new Exception("Error: localizador no encontrado " + e.getMessage());
        }
    }

    public void clickOnButtonVentas() throws Exception {

        try {
            clickElement("/html/body/app-root/app-dashboard/div/div[2]/div/app-modulos/div/div/div[6]/div/div");
        } catch (Exception e) {
            throw new Exception("Error: localizador no encontrado " + e.getMessage());
        }
    }

    public void loginToNavigateClient() throws Exception {
        navigateLogin();
        clickOnButton();
        clickOnButtonVentas();
    }
}
