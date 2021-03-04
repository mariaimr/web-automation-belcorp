package co.com.retobelcorp.certification.pruebatecnica.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SetAddressPage {
    public static final Target DEPARTMENT = Target.the("Input Depatment").locatedBy("//*[@id='address.regionIsoParent2']//*[text()='{0}']");
    public static final Target PROVINCE = Target.the("Input province").locatedBy("//*[@id='address.regionIsoParent1']//*[text()='{0}']");
    public static final Target DISTRICT = Target.the("Input district").locatedBy("//*[@id='address.regionIso']//*[text()='{0}']");
    public static final Target ADDRESS = Target.the("Input address").located(By.id("address.line1"));
    public static final Target ADDITIONAL_INFORMATION = Target.the("Input additional information").located(By.id("address.line2"));
    public static final Target REFERENCE = Target.the("Input reference").located(By.id("address.referencia"));
    public static final Target PHONE = Target.the("Input phone").located(By.id("address.phone"));
    public static final Target ADDRESS_SUBMIT = Target.the("Button address submit").located(By.id("addressSubmit"));
    public static final Target CONFIRM_ADDRESS = Target.the("Field where it shows address").locatedBy("//*[@class='address']");

}