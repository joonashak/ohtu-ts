package ohtu.ts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.util.ArrayList;
import java.util.List;
import ohtu.ts.db.Database;
import ohtu.ts.io.StubIO;
import ohtu.ts.services.ReadingTipService;
import ohtu.ts.ui.MockTerminal;
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
    private MockTerminal terminal;

    @Before
    public void SetUp() {
        commands = new ArrayList<>();
        io = new StubIO(commands);
        service = new ReadingTipService();
        terminal = new MockTerminal(new int[]{80, 24}, "nix");
        ui = new TextUI(io, service, terminal);
        Database db = new Database();
        db.migrate();
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

    @When("blog title {string}, author {string} and url {string} are given")
    public void titleAuthorAndUrlAreGiven(String title, String author, String url) {
        commands.add(title);
        commands.add(author);
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
    }

    @Then("system will respond with a list that contains at least the titles {string} {string}")
    public void systemWillRespondWithAListThatContainsAtLeastTheTitles(String string, String string2) {
        commands.add("");
        commands.add("3");
        ui.run();
        String printout = io.getOutputs().get(io.lastOutputIndex() - 2);
        assertThat(printout, containsString(string2));
        assertThat(printout, containsString(string));
    }

    @Then("system will respond with a list that contains the type {string}")
    public void systemWillRespondWithAListThatContainsTheType(String string) {
        commands.add("");
        commands.add("3");
        ui.run();
        String printout = io.getOutputs().get(io.lastOutputIndex() - 2);
        assertThat(printout, containsString(string));

    }

    @Then("system will respond with book's information: title {string}, author {string} and ISBN {string}")
    public void systemWillRespondWithBookSInformationTitleAuthorAndISBN(String string, String string2, String string3) {
        commands.add("");
        commands.add("");
        commands.add("3");
        ui.run();
        String printout = io.getOutputs().get(io.lastOutputIndex() - 4);
        assertThat(printout, containsString(string));
        assertThat(printout, containsString(string2));
        assertThat(printout, containsString(string3));
    }

    @When("no filters have been set")
    public void noFiltersHaveBeenSet() {
        // nothing yet
    }

    @Given("video title {string} and URL {string} are given")
    public void videoTitleAndURLAreGiven(String title, String url) {
        commands.add(title);
        commands.add(url);
    }

    @Then("the correct command will be run in the terminal on linux")
    public void theCorrectCommandWillBeRunInTheTerminalOnLinux() {
        commands.add("");
        commands.add("3");
        ui.run();
        List<String> cmd = terminal.getCommandsRun();
        String commandRunLast = cmd.get(cmd.size() - 1);
        assertThat(commandRunLast, is("xdg-open google.com"));
    }

    @After
    public void teardown() {
        //delete dbfile after each scenario
        new Database().getDbFile().delete();
    }

}
