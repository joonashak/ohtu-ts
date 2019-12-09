/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class Browser {

    private final String url;
    private final String OS;
    private final Runtime rt;

    public Browser(String url, String os, Runtime rt) {
        this.url = url;
        this.OS = os;
        this.rt = rt;
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
            retVal = rt.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
        } else if (OS.contains("mac")) {
            retVal = rt.exec("open " + url).waitFor();
        } else if (OS.contains("nix") || OS.contains("nux")) {
            /*
            String display = System.getenv("DISPLAY");
            if (display == null) {
                return false;
            }
             */
            retVal = rt.exec("xdg-open " + url).waitFor();
        } else {
            return false;
        }
        return retVal == 0;
    }

    private void tryBrowsers() throws IOException, InterruptedException {
        if (OS.contains("win")) {
            return;
        }
        String[] browsers = {"links", "lynx", "firefox", "chrome", "chromium", "epiphany",
            "mozilla", "konqueror", "netscape", "opera", "epiphany", "iceweasel"};
        ProcessBuilder pb = new ProcessBuilder();
        for (String browser : browsers) {
            pb.command("sh", "-c", browser + ' ' + url);
            if (pb.start().waitFor(1000, TimeUnit.MILLISECONDS)) {
                return;
            }
        }
    }

    public void launch() {
        try {
            if (!tryRuntimeScriptingMethod()) {
                // do something potentially dangerous
                tryBrowsers();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
