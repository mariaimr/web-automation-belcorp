package co.com.retobelcorp.certification.pruebatecnica.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.MESSAGE_PRODUCT_ADDED;

@Subject("the message when product added")
public class TheProduct implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return MESSAGE_PRODUCT_ADDED.resolveFor(actor).getText().toLowerCase();
    }

    public static Question<String> wasAddedSuccesfully() {
        return new TheProduct();
    }
}
