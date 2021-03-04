package co.com.retobelcorp.certification.pruebatecnica.tasks;

import co.com.retobelcorp.certification.pruebatecnica.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.model.builders.UserBuilder.theUser;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.LogInAsGuestPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class LogInAsGuest implements Task {

    private User user = theUser().build();

    @Override
    @Step("{0} logs in as guest")
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Enter.theValue(user.getFirstName()).into(GUEST_FIRST_NAME),
                Enter.theValue(user.getLastName()).into(GUEST_LAST_NAME),
                Enter.theValue(user.getEmail()).into(GUEST_EMAIL),
                Enter.theValue(user.getEmail()).into(GUEST_CONFIRM_EMAIL),
                Click.on(GUEST_AUTHORIZATION),
                Click.on(LOGIN_GUEST)
        );
    }

    public static LogInAsGuest toBuyProduct() {
        return instrumented(LogInAsGuest.class);
    }
}
