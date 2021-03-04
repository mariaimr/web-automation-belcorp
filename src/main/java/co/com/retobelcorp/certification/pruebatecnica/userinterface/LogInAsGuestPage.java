package co.com.retobelcorp.certification.pruebatecnica.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogInAsGuestPage {

    public static final Target GUEST_FIRST_NAME = Target.the("Input FirstName").located(By.id("guest.firstName"));
    public static final Target GUEST_LAST_NAME = Target.the("Input LastName").located(By.id("guest.lastName"));
    public static final Target GUEST_EMAIL = Target.the("Input email").located(By.id("guest.email"));
    public static final Target GUEST_CONFIRM_EMAIL = Target.the("Input confirm email").located(By.id("guest.confirm.email"));
    public static final Target GUEST_AUTHORIZATION = Target.the("Check authorization").locatedBy("//*[@name='agreeToReceivePublicity']");
    public static final Target LOGIN_GUEST = Target.the("Button login").locatedBy("//*[@id='guestForm']//button");
}