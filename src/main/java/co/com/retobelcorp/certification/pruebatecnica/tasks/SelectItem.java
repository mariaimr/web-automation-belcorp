package co.com.retobelcorp.certification.pruebatecnica.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.BUTTON_SHOPPING_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class SelectItem implements Task {

    private String product;

    public SelectItem(String product) {
        this.product = product;
    }

    @Override
    @Step("{0} performs buying product")
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Click.on(BUTTON_SHOPPING_PRODUCT.of(product))
        );

        theActor.attemptsTo(
                AddAditionalQuantity.toProductSelected(product),
                LogInAsGuest.toBuyProduct(),
                SetAddress.toShipProduct()
        );

    }

    public static SelectItem andBuyProducto(String product) {
        return instrumented(SelectItem.class, product);
    }
}
