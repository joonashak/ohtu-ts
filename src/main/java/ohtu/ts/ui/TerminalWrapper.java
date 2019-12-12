/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>
 */
public interface TerminalWrapper {

    public int[] getCommandLineDimensions() throws Exception;

    public String getOS();

    public Process exec(String... cmd);
}
