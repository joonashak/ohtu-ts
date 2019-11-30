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
import ohtu.ts.ui.TextUI;
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
        ui = new TextUI(io, service);
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
        commands.add(author);
        commands.add(ISBN);
        commands.add(title);
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWithLukuvinkkiLisätty(String string) {
        commands.add("3");
        ui.run();
        // The sixth thing that this program prints:
        String printout = io.getOutputs().get(5);
        assertThat(printout,
                is(string));             
    }
    
    @Then("system will respond first with {string}")
    public void systemWillRespondFirstWithReadingTip(String string) {
        commands.add("3");
        ui.run();
        //Ensure there is nothing before the first reading tip
        //i.e the last thing in StubIO outputs is ask command        
        String printout = io.getOutputAt(io.lastOutputIndex() - 3);
        assertThat(printout,
                is(ui.askCommand()));
        //Get the first reading tip which is third last print from stubIO outputs    
        printout = io.getOutputAt(io.lastOutputIndex() - 2);
        assertThat(printout,
                is(string));
    }
    
    @Then("system will respond second with {string}")
    public void systemWillRespondSecondWithReadingTip(String string) {
        // Get the second reading tip which is second last print from stubIO outputs
        String printout = io.getOutputAt(io.lastOutputIndex() - 1);
        assertThat(printout,
                is(string));
    }
    
    @After
    public void teardown() {
        //delete dbfile after each scenario
        new Database().getDbFile().delete();        
    }
    
}
