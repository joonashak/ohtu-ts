/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public class MockProcess extends Process {

    private String cmd;
    private String OS;

    public MockProcess(String OS, String cmd) {
        this.OS = OS;
        this.cmd = cmd;
    }

    @Override
    public OutputStream getOutputStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getInputStream() {
        String s = (OS.contains("win")) ? "asdf:1\nfdsa:2\n" : "24";
        return new ByteArrayInputStream(s.getBytes());
    }

    @Override
    public InputStream getErrorStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int waitFor() throws InterruptedException {
        return 0;
    }

    @Override
    public int exitValue() {
        return 0;
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException();
    }

    /**
     * Get command for testing purposes
     * @return cmd
     */
    public String getCmd() {
        return cmd;
    }

}
