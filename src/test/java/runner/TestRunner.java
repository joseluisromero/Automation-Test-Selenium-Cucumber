package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import runner.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = {"steps"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Test")
public class TestRunner {
    //Cerramos la instancia del browser cada vez que termina un test
    @AfterClass
    public static void closeBrowser() {
        BasePage.closeBrowser();
    }
}
