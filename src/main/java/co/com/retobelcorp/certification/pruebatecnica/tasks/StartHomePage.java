package co.com.retobelcorp.certification.pruebatecnica.tasks;

import co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError;
import co.com.retobelcorp.certification.pruebatecnica.userinterface.BelcorpHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static co.com.retobelcorp.certification.pruebatecnica.exceptions.BelcorpError.MESSAGE_MENU_CATEGORIES_NOT_LOADED;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.BelcorpHomePage.MENU;
import static co.com.retobelcorp.certification.pruebatecnica.userinterface.BelcorpHomePage.SUBMENU;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class StartHomePage implements Task {

    private BelcorpHomePage tiendaBelcorpPage;
    private String category;
    private String subcategory;

    public StartHomePage(String category, String subcategory) {
        this.category = category;
        this.subcategory = subcategory;
    }

    @Override
    @Step("{0} performs a selecting categories")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Open.browserOn(tiendaBelcorpPage));

        theActor.should(seeThat(the(MENU.of(category)), isVisible())
                .orComplainWith(BelcorpError.class,
                        MESSAGE_MENU_CATEGORIES_NOT_LOADED));

        theActor.attemptsTo(
                MoveMouse.to(MENU.of(category)),
                Click.on(SUBMENU.of(subcategory))
        );

    }

    public static StartHomePage selecting(String category, String subcategory) {
        return instrumented(StartHomePage.class, category, subcategory);
    }

}
