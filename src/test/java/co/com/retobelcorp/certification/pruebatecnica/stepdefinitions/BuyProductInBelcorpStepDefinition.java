package co.com.retobelcorp.certification.pruebatecnica.stepdefinitions;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError;
import co.com.retobelcorp.certification.pruebatecnica.questions.ThePurchase;
import co.com.retobelcorp.certification.pruebatecnica.tasks.CancelPurchase;
import co.com.retobelcorp.certification.pruebatecnica.tasks.SelectItem;
import co.com.retobelcorp.certification.pruebatecnica.tasks.StartHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError.MESSAGE_FAILED_DELETE_ITEMS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.Is.is;

public class BuyProductInBelcorpStepDefinition {

    private static final String PRODUCT_DELETED_SUCCESFULLY = "El producto ha sido eliminado de tu Carrito." ;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) wants to start buying a product selecting the category (.*) and the subcategory (.*)$")
    public void startBuying(String actor,String category, String subcategory ) {
        theActorCalled(actor).wasAbleTo(
                StartHomePage.selecting(category, subcategory));
    }

    @When("^Maria adds the product (.*) and she wants buying it$")
    public void addsProductToCart(String productName) {
        theActorInTheSpotlight().attemptsTo(
               SelectItem.andBuyProducto(productName)
        );
    }

    @And("^Maria cancels the purchase$")
    public void cancelsThepurchase() {
        theActorInTheSpotlight().attemptsTo(
                CancelPurchase.deletingAllOfProductsSelected()
        );
    }

    @Then("^Maria should see the purchase canceled$")
    public void mariaShouldSeeThePurchaseCanceled() {
        theActorInTheSpotlight().should(
                seeThat(ThePurchase.wasCanceledSuccesfully(), is(PRODUCT_DELETED_SUCCESFULLY))
       .orComplainWith(BelcorpError.class, MESSAGE_FAILED_DELETE_ITEMS));

    }

}