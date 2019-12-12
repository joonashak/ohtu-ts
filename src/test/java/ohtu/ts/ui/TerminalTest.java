/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class TerminalTest {

    Terminal t;

    @Test
    public void dimensionsAlwaysReturnSomething() throws Exception {
        t = new Terminal("");
        int[] dims = t.getCommandLineDimensions();
        assertThat(dims, is(not(nullValue())));
    }

    @Test
    public void execBehavesSomewhatAsExpectedOnUnix() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        t = new Terminal(os);
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            int[] d = t.getCommandLineDimensions();
            assertThat(d, is(not(nullValue())));
        }
    }

    @Test
    public void execBehavesOnWindows() throws Exception {
        String os = System.getProperty("os.name").toLowerCase();
        t = new Terminal(os);
        if (os.contains("win")) {
            int[] d = t.getCommandLineDimensions();
            assertThat(d, is(not(nullValue())));
        }
    }

}
