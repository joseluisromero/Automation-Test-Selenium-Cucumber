package com.automation.selenium.cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.automation.selenium.cucumber.runner.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/automation/selenium/cucumber/features",
        glue = {"com/automation/selenium/cucumber/steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
        ,
        tags = "@Test"
        , publish = true

)
public class TestRunner {
    //Cerramos la instancia del browser cada vez que termina un test
    @AfterClass
    public static void closeBrowser() {
        BasePage.closeBrowser();
    }
}
