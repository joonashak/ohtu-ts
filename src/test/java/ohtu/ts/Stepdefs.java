package ohtu.ts;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import ohtu.ts.db.Database;
import ohtu.ts.io.StubIO;
import ohtu.ts.services.ReadingTipService;
import ohtu.ts.ui.Terminal;
import ohtu.ts.ui.TextUI;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author ida, arttu
 */
public class Stepdefs {

    private List<String> commands;
    private StubIO io;
    private ReadingTipService service;
    private TextUI ui;

    @Before
    public void SetUp() {
        commands = new ArrayList<>();
        io = new StubIO(commands);
        service = new ReadingTipService();
        ui = new TextUI(io, service, new Terminal());
    }

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
        commands.add(title);
        commands.add(author);
        commands.add(ISBN);
    }

    @When("video title {string}, url {string} are given")
    public void titleAndUrlAreGiven(String title, String url) {
        commands.add(title);
        commands.add(url);
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWithLukuvinkkiLisätty(String string) {
        commands.add("3");
        ui.run();
        // The last thing that this program prints after loop starts back:
        String printout = io.getOutputs().get(io.lastOutputIndex() - 1);
        assertThat(printout,
                is(string));
        ui.stop(); // pull an emergency stop to prevent stack overflow
    }

    @Then("system will respond with a list that contains {string} {string}")
    public void systemWillRespondWithAListThatContainsAtLeastTheTitles(String string, String string2) {
        ui.run();
        String[] printout = new String[2];
        printout[0] = io.getOutputs().get(io.lastOutputIndex() - 2);
        printout[1] = io.getOutputs().get(io.lastOutputIndex() - 1);
        assertThat(printout[0], containsString(string));
        assertThat(printout[1], containsString(string2));
        ui.stop();  // pull an emergency stop to prevent stack overflow
    }

    @When("no filters have been set")
    public void noFiltersHaveBeenSet() {
        // nothing yet
    }

    @After
    public void teardown() {
        //delete dbfile after each scenario
        new Database().getDbFile().delete();
    }

}
