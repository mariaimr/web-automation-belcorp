package co.com.retobelcorp.certification.pruebatecnica.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.QUANTITY_PRODUCTS_CART;

@Subject("the number of items in the cart")
public class TheQuantity implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return QUANTITY_PRODUCTS_CART.resolveFor(actor).getText();
    }

    public static Question<String> addedInCart() {
        return new TheQuantity();
    }
}
