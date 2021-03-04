package co.com.retobelcorp.certification.pruebatecnica.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.retobelcorp.certification.pruebatecnica.userinterface.AddProductToCartPage.MESSAGE_PRODUCT_DELETED;

@Subject("the message")
public class ThePurchase implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return MESSAGE_PRODUCT_DELETED.resolveFor(actor).getText().split("\n")[1];
    }

    public static Question<String>  wasCanceledSuccesfully() {
        return new ThePurchase();
    }
}