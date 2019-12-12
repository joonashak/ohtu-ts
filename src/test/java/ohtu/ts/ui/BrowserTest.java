/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class BrowserTest {

    @Test
    public void someTest() {

    }

    @Test
    public void behaveLinux() throws Exception {
        Browser bLinux = new Browser("google.com",
                new MockTerminal(new int[]{12, 12}, "linux"));
        assertThat(bLinux.launch(), is(true));
    }

    @Test
    public void behaveWindows() throws Exception {
        Browser bWindows = new Browser("google.com",
                new MockTerminal(new int[]{12, 12}, "windows"));
        assertThat(bWindows.launch(), is(true));
    }

    @Test
    public void behaveMac() throws Exception {
        Browser bMac = new Browser("google.com",
                new MockTerminal(new int[]{12, 12}, "mac"));
        assertThat(bMac.launch(), is(true));
    }
}
