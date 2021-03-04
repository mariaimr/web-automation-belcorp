package co.com.retobelcorp.certification.pruebatecnica.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddProductToCartPage {
    public static final Target BUTTON_SHOPPING_PRODUCT = Target.the("CartButton product selected").locatedBy("//*[@title='{0}']/following-sibling::div//button");
    public static final Target MESSAGE_PRODUCT_ADDED = Target.the("Message product added succesfully").locatedBy("//*[@id='cboxTitle']//span/div//span");
    public static final Target BUTTON_GO_TO_PAY = Target.the("Button go to pay").locatedBy("//*[@id='cboxLoadedContent']//a[contains(@class,'checkout')]");
    public static final Target BUTTON_ADD_TO_CART = Target.the("Button add to cart").located(By.id("addToCartButton"));
    public static final Target BUTTON_PAY = Target.the("Button pay").locatedBy("//*[@id='addToCartLayer']//a[contains(@class,'add-to-cart-button')]");
    public static final Target QUANTITY_PRODUCTS_CART = Target.the("Quantity products in cart").locatedBy("//li//div[contains(@class,'mini-cart-count')]/span");
    public static final Target BUTTON_CONTINUE_PAY = Target.the("Button continue pay").locatedBy("//*[@class='cart-side-bar']//button[contains(text(),'Ir a pagar')]");
    public static final Target BUTTON_DELETE_PRODUCT = Target.the("Button delete products").locatedBy("//*[@id='actionEntry_0']/a/span");
    public static final Target MESSAGE_PRODUCT_DELETED = Target.the("Message products deleted").locatedBy("//*[contains(@class,'alert-success')]");
    public static final Target DETAIL_PRODUCT_SELECTED = Target.the("Link Detail product").locatedBy("//*[@id='addToCartLayer']//*[@title='{0}']");


}
