/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.domain;

import ohtu.ts.domain.Book;
import ohtu.ts.domain.Types;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas
 */
public class TypesTest {
    
    @Test
    public void typesGetIdMethodWorks() {
        assertEquals(Types.BOOK.getId(), 1);
    }
    
    @Test
    public void typesGetNameMethodWorks() {
        assertEquals(Types.BOOK.getName(), "Kirja");
    }
}
