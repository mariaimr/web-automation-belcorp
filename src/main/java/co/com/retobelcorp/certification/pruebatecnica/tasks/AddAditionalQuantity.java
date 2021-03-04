package co.com.retobelcorp.certification.pruebatecnica.tasks;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError;
import co.com.retobelcorp.certification.pruebatecnica.questions.TheProduct;
import co.com.retobelcorp.certification.pruebatecnica.questions.TheQuantity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError.MESSAGE_FAILED_ADD_TO_CART;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.core.Is.is;


public class AddAditionalQuantity implements Task {

    private String product;
    private final static String MESSAGE_PRODUCT_ADDED = "has agregado un producto a tu bolsa de compras";

    public AddAditionalQuantity(String product) {
        this.product = product;
    }

    @Override
    @Step("{0} adds additional quantity")
    public <T extends Actor> void performAs(T theActor) {

        theActor.should(seeThat(TheProduct.wasAddedSuccesfully(), is(MESSAGE_PRODUCT_ADDED))
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_ADD_TO_CART));

        theActor.should(seeThat(TheQuantity.addedInCart(), is("1"))
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_ADD_TO_CART));

        theActor.attemptsTo(
                Click.on(DETAIL_PRODUCT_SELECTED.of(product)),
                Click.on(BUTTON_ADD_TO_CART),
                Click.on(BUTTON_PAY),
                Click.on(BUTTON_CONTINUE_PAY)
        );

        theActor.should(seeThat(TheQuantity.addedInCart(), is("2"))
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_ADD_TO_CART));

    }

    public static AddAditionalQuantity toProductSelected(String product) {
        return instrumented(AddAditionalQuantity.class, product);
    }
}
