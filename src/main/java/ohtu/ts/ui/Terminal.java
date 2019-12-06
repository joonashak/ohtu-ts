/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Class for extracting terminal size from the command line, using standard
 * external tools. Caution: there is no platform-independent surefire way to get
 * the dimensions from the command line or otherwise, so this class utilizes
 * some more or less typical external commands. Use with care.
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class Terminal {

    private final String OS;

    public Terminal() {
        OS = System.getProperty("os.name").toLowerCase();
    }

    /**
     * Testing method for manual debugging.
     */
    public void testMe() {
        System.out.println(OS + ": ");
        int[] dims = null;
        try {
            dims = getCommandLineDimensions();
        } catch (Exception ex) {
            // fail silently...
            return;
        }
        System.out.println("width: " + dims[0] + " height: " + dims[1]);
    }

    /**
     * Get the terminal size independent of platform.
     *
     * @return dimensions
     * @throws Exception
     */
    public int[] getCommandLineDimensions()
            throws Exception {
        if (OS.contains("nux") || OS.contains("nix") || OS.contains("mac")) {
            ProcessBuilder heightCommand
                    = new ProcessBuilder("sh", "-c", "tput lines");
            int height = parseCommandLineLinux(heightCommand);
            ProcessBuilder widthCommand
                    = new ProcessBuilder("sh", "-c", "tput cols");
            int width = parseCommandLineLinux(widthCommand);
            return new int[]{width, height};
        } else if (OS.contains("win")) {
            ProcessBuilder command
                    = new ProcessBuilder("cmd.exe", "/c", "mode con|find \"n\"");
            int[] dims = parseCommandLineWindows(command);
            return dims;
        } else {
            // os not determined, falling back to defaults:
            return new int[]{80, 24};
        }
    }

    /**
     * Linux-specific output parsing utility method.
     *
     * @param procBuilder
     * @return dims
     * @throws Exception
     */
    private int parseCommandLineLinux(ProcessBuilder procBuilder)
            throws Exception {
        assert (!procBuilder.command().isEmpty()): "Process command not initialized";
        Process process = procBuilder.start();
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = reader.readLine(); // expecting one line
        int retVal = process.waitFor();
        if (retVal != 0) {
            throw new Exception("Abnormal command line");
        }
        reader.close();
        return Integer.parseInt(line);
    }

    /**
     * Windows-specific output parsing util method.
     *
     * @deprecated experimental, in case user uses Windows
     * @param procBuilder
     * @return dims
     * @throws IOException
     */
    @Deprecated
    private int[] parseCommandLineWindows(ProcessBuilder procBuilder)
            throws Exception {
        assert (!procBuilder.command().isEmpty()): "Process command not initialized";
        Process process = procBuilder.start();
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String[] lines = reader.lines().toArray(String[]::new); // expecting two lines
        int retVal = process.waitFor();
        if (retVal != 0) {
            throw new Exception("Abnormal command line");
        }
        reader.close();
        return new int[]{Integer.parseInt(lines[0].split(":")[1],
            Integer.parseInt(lines[1].split(":")[1]))};
    }

}
