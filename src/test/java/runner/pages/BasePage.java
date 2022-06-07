package runner.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    //bloque statico para  crear el driver una sola vez para todas  las  instancia de las otras paginas mas una espera
    //de 10 segundo si encuentra el elemto antes de ese tiempo continuara y sino lo  encuentra botara
    //una exception
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        //va ha esperar 10 segundo sino botara  una error si lo encuentra  antes continuara
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement findId(String locator) {
        //esperar hasta
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    //el xpath es el unico metodo para poder identificar todos los pasos OJO
    public WebElement findXpath(String locator) {
        //esperar hasta
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        findXpath(locator).click();
    }

    public String getText(String locator) {
        return findXpath(locator).getText();
    }

    public static void closeBrowser() {
        driver.quit();
    }

}
