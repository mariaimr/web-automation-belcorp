package co.com.retobelcorp.certification.pruebatecnica.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.BUTTON_GO_TO_PAY;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.BelcorpHomePage.CART_ICON;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.BelcorpHomePage.ESIKA_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BackToCart implements Interaction {

    @Override
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Click.on(ESIKA_HOME),
                Click.on(CART_ICON),
                Click.on(BUTTON_GO_TO_PAY)
        );
    }

    public static BackToCart toCancelThePurshase() {
        return instrumented(BackToCart.class);
    }


}
