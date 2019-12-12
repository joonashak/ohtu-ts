/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class MockTerminal implements TerminalWrapper {

    private int[] dimensions;
    private String OS;
    private List<String> commandsRun;

    public MockTerminal(int[] dimensions, String OS) {
        this.dimensions = dimensions;
        this.OS = OS;
        this.commandsRun = new ArrayList<>();
    }

    @Override
    public int[] getCommandLineDimensions() throws Exception {
        return dimensions;
    }

    @Override
    public String getOS() {
        return OS;
    }

    @Override
    public Process exec(String... cmd) {
        String s = Arrays.stream(cmd).collect(Collectors.joining(" "));
        commandsRun.add(s);
        return new MockProcess(OS, s);
    }

    public List<String> getCommandsRun() {
        return commandsRun;
    }

}
