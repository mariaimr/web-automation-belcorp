package co.com.retobelcorp.certification.pruebatecnica.tasks;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError;
import co.com.retobelcorp.certification.pruebatecnica.model.Address;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError.MESSAGE_FAILED_SET_ADDRESS;
import static co.com.retobelcorp.certification.pruebatecnica.model.builders.AddressBuilder.theAddress;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.SetAddressPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class SetAddress implements Task {

    private Address address = theAddress().build();
    @Override
    @Step("{0} sets address")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(DEPARTMENT.of(address.department())),
                Click.on(PROVINCE.of(address.province())),
                Click.on(DISTRICT.of(address.district())),
                Enter.theValue(address.address()).into(ADDRESS),
                Enter.theValue(address.additionalInformation()).into(ADDITIONAL_INFORMATION),
                Enter.theValue(address.reference()).into(REFERENCE),
                Enter.theValue(address.phone()).into(PHONE),
                Click.on(ADDRESS_SUBMIT)
        );

        theActor.should(seeThat(the(CONFIRM_ADDRESS), isVisible())
                .orComplainWith(BelcorpError.class,
                        MESSAGE_FAILED_SET_ADDRESS));
    }

    public static SetAddress toShipProduct() {
        return instrumented(SetAddress.class);
    }
}
