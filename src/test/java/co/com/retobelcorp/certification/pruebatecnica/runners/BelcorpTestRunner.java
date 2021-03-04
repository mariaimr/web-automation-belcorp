package co.com.retobelcorp.certification.pruebatecnica.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/buy_product.feature",
        glue = {"co.com.retobelcorp.certification.pruebatecnica.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class BelcorpTestRunner {

}
