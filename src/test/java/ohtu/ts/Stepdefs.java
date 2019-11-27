package ohtu.ts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import ohtu.ts.io.StubIO;
import ohtu.ts.services.ReadingTipService;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import ui.TextUI;

/**
 *
 * @author ida, arttu
 */
public class Stepdefs {

    private List<String> commands = new ArrayList<>();
    private StubIO io = new StubIO(commands);
    private TextUI app = new TextUI(io, new ReadingTipService());

    @Given("command {string} is selected")
    public void CommandIsSelected(String command) {
        commands.add(command);
    }

    @When("type {string} is given")
    public void typeIsGiven(String type) {
        commands.add(type);
    }

    @When("book title {string}, author {string} and ISBN {string} are given")
    public void titleAuthorAndISBNAreGiven(String title, String author, String ISBN) {
        commands.add(author);
        commands.add(ISBN);
        commands.add(title);
    }

    @Then("system will respond with Lukuvinkki lisätty: {string}")
    public void systemWillRespondWithLukuvinkkiLisätty(String string) {
        app.run();
        // The sixth thing that this program prints:
        String printout = io.getOutputs().get(5);
        assertThat(printout,
                is("Lukuvinkki lisätty: " + string));
    }

}