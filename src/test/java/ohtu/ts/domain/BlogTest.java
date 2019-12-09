/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Joonas
 */
public class BlogTest {
    
    Blog blog;
    String blogString;
    
    @Before
    public void setUp() {
        blog = new Blog(1, "Koodauksen 101", "Jesse Jee", "http://wwww.blogpost.com/code");
    }

    @Test
    public void bookShouldBeCreated() {
        assertEquals("Jesse Jee", blog.getAuthor());
        assertEquals("Koodauksen 101", blog.getTitle());
        assertEquals("http://wwww.blogpost.com/code", blog.getUrl());
        assertEquals(blog.getType(), Types.BLOG);
    }
}

