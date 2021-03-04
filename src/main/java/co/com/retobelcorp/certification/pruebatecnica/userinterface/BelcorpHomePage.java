package co.com.retobelcorp.certification.pruebatecnica.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://esika.tiendabelcorp.com/pe")
public class BelcorpHomePage extends PageObject {

    public static final Target MENU = Target.the("Menu Categories").locatedBy("//*[contains(@id,'esika')]//a[@title='{0}']");
    public static final Target SUBMENU = Target.the("Submenu Categories").locatedBy("//*[@title='{0}']");
    public static final Target ESIKA_HOME = Target.the("Link Esika home").locatedBy("//div[@class='row']//*[@id='lnk-sup-esika' and @class='esika-active']");
    public static final Target CART_ICON = Target.the("Link cart").locatedBy("//li//*[@class='yCmsComponent']//a");

}
