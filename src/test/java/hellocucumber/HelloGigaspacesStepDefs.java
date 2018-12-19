package hellocucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.EmbeddedSpaceConfigurer;

public class HelloGigaspacesStepDefs {

    private GigaSpace space;
    private String read;

    @Given("^i connected to embedded space$")
    public void iConnectedToEmbeddedSpace() {
        space = new GigaSpaceConfigurer(new EmbeddedSpaceConfigurer("HelloGigaspacesSpace")).gigaSpace();
    }

    @And("^I write \"([^\"]*)\" to the space$")
    public void iWriteToTheSpace(String toWrite) throws Throwable {
        space.write(new MyData(toWrite));
    }

    @When("^I read from the space$")
    public void iReadFromTheSpace() {
        read = space.read(new MyData()).getStr();
    }

    @Then("^I should get \"([^\"]*)\"$")
    public void iShouldGet(String expected) throws Throwable {
        String errorMsg = String.format("got %s , expect: %s\n", read, expected);
        Assert.assertEquals(errorMsg, expected, read);
    }
}
