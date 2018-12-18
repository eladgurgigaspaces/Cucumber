package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.text.MessageFormat;
import java.time.DayOfWeek;

import static java.time.DayOfWeek.SUNDAY;

public class Stepdefs {

    private DayOfWeek today;
    private String actualAnswer;


    @Given("^today is Sunday$")
    public void todayIsSunday() {
        today = SUNDAY;
    }

    @When("^I ask whether it's Friday yet$")
    public void iAskWhetherItSFridayYet() {
        actualAnswer = isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void iShouldBeTold(String expectedAnswer) throws Throwable {
        String errorMsg = MessageFormat.format("I should be told: {0} , not : {1}", expectedAnswer, actualAnswer);
        Assert.assertEquals(errorMsg, expectedAnswer, actualAnswer);
    }

    private String isItFriday(DayOfWeek today) {
        String res;

        switch (today) {
            case FRIDAY:
                res = "Yep";
                break;
            default:
                res = "Nope";
                break;
        }

        return res;
    }

}
