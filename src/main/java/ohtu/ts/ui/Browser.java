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
    private final TerminalWrapper term;

    public Browser(String url, TerminalWrapper term) {
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
        Process p;
        if (OS.contains("win")) {
            p = term.exec("rundll32", "url.dll,FileProtocolHandler", url);
        } else if (OS.contains("mac")) {
            p = term.exec("open", url);
        } else if (OS.contains("nix") || OS.contains("nux")) {
            p = term.exec("xdg-open", url);
        } else {
            return false;
        }
        return p == null ? false : p.waitFor() == 0;
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
            if (p == null) {
                continue;
            }
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
            // fail silently...
        }
    }
}
