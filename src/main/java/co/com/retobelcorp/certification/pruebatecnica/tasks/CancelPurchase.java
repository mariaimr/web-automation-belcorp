package co.com.retobelcorp.certification.pruebatecnica.tasks;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError;
import co.com.retobelcorp.certification.pruebatecnica.interactions.BackToCart;
import co.com.retobelcorp.certification.pruebatecnica.questions.TheQuantity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError.MESSAGE_FAILED_ADD_TO_CART;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.BUTTON_DELETE_PRODUCT;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.MESSAGE_PRODUCT_DELETED;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.core.Is.is;


public class CancelPurchase implements Task {

    @Override
    @Step("{0} cancels the purchase")
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                BackToCart.toCancelThePurshase(),
                Click.on(BUTTON_DELETE_PRODUCT)
        );

        theActor.should(seeThat(the(MESSAGE_PRODUCT_DELETED), isVisible())
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_ADD_TO_CART));

        theActor.should(seeThat(TheQuantity.addedInCart(), is("0"))
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_ADD_TO_CART));


    }

    public static CancelPurchase deletingAllOfProductsSelected() {
        return instrumented(CancelPurchase.class);
    }
}
