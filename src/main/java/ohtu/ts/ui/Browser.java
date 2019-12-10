/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.awt.Desktop;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class Browser {

    private final String url;
    private final String OS;
    private final Terminal term;

    public Browser(String url, Terminal term) {
        this.url = url;
        this.OS = term.getOS();
        this.term = term;
    }

    private boolean tryDesktopMethod()
            throws Exception {
        if (!Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            return false;
        }
        Desktop dt = Desktop.getDesktop();
        dt.browse(new URI(url));
        return true;
    }

    private boolean tryRuntimeScriptingMethod()
            throws Exception {
        int retVal;
        if (OS.contains("win")) {
            retVal = term.exec("rundll32", "url.dll,FileProtocolHandler", url).waitFor();
        } else if (OS.contains("mac")) {
            retVal = term.exec("open", url).waitFor();
        } else if (OS.contains("nix") || OS.contains("nux")) {
            retVal = term.exec("xdg-open", url).waitFor();
        } else {
            return false;
        }
        return retVal == 0;
    }

    private void tryBrowsers()
            throws Exception {
        if (OS.contains("win")) {
            return;
        }
        String[] browsers = {"firefox", "chrome", "chromium", "epiphany",
            "mozilla", "konqueror", "netscape", "opera", "epiphany", "links2", "iceweasel"};
        for (String browser : browsers) {
            Process p = term.exec("sh", "-c", browser + ' ' + url);
            if (p.waitFor(1000, TimeUnit.MILLISECONDS)) {
                return;
            }
        }
    }

    public void launch() {
        try {
            if (!tryRuntimeScriptingMethod()) {
                if (!tryDesktopMethod()) {
                    // do something potentially dangerous
                    tryBrowsers();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
