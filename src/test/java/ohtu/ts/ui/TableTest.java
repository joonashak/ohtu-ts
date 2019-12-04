/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joonas
 */
public class TableTest {

    Table table;

    @Before
    public void setUp() {
        table = new Table(10, 10);
    }

    @Test
    public void tableMethodGetHeightWorksWithEmptyTable() {
        assertEquals(table.getHeight(), 2);
    }

    @Test
    public void tableMethodGetWidthWorksWithEmptyTable() {
        assertEquals(table.getWidth(), 0);
    }

    @Test
    public void tableSetHeadersMethodWorks() {
        String[] headers = new String[]{"testataan", "vielä", "hieman", "lisää"};
        table.setHeaders(headers);
        Assert.assertArrayEquals(table.getHeaders(), headers);
    }

    @Test
    public void tableColumnWidthsSetAndGetMethodWorks() {
        int[] widths = new int[]{1, 5};
        table.setColumnWidths(widths);
        Assert.assertArrayEquals(table.getColumnWidths(), new int[]{1, 5});
    }

    @Test(expected = IllegalArgumentException.class)
    public void tableSetColumnWidthsThrowsIllegalArgumentError() {
        int[] widths = new int[]{6, 2, 2, 2, 3, 5, 6, 7, 8, 8, 8, 6, 7};
        table.setColumnWidths(widths);
    }

    @Test
    public void tableAddRowMethodWorks() {
        String[] columnVals = new String[]{"jes", "aasi", "testi"};
        table.addRow(columnVals);
        assertEquals(table.getHeight(), 3);
        table.addRow(columnVals);
        table.addRow(columnVals);
        table.addRow(columnVals);
        assertEquals(table.getHeight(), 6);
    }
    
    @Test
    public void tableToStringWorks() {
            // to-do
    }
}
