/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ida
 */
public class CommandsTest {
    private Commands commands;
    

    @Test
    public void findCommandAdd() {
        Commands com = commands.find(1);
        assertEquals(com.getCode(), 1);
        assertEquals(com.getTooltip(), "Lisää lukuvinkki");
    }
    
    @Test
    public void findCommandList() {
        Commands com = commands.find(2);
        assertEquals(com.getCode(), 2);
        assertEquals(com.getTooltip(), "Selaa lukuvinkkejä");
    }
    
    @Test
    public void findCommandQuit() {
        Commands com = commands.find(3);
        assertEquals(com.getCode(), 3);
        assertEquals(com.getTooltip(), "Lopeta");
    }
    
    @Test
    public void dontFindCommandThatDoesntExist() {
        Commands com = commands.find(0);
        assertEquals(com, null);
    }
    
}
