package com.realdolmen.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DevLabsTagImplTest {
    @Test
    public void testSave() throws Exception {
        // To be implemented
    }

    @Test
    public void testDelete() throws Exception {
        // To be implemented
    }

    @Test
    public void testUnique() throws Exception {
        DevLabsTagImpl tag1 = new DevLabsTagImpl("Test");
        DevLabsTagImpl tag2 = new DevLabsTagImpl("Test");

        assertEquals(tag1, tag2);
        assertTrue(tag1.hashCode() == tag2.hashCode());

        tag2.setName("Not test");

        assertNotEquals(tag1, tag2);
        assertFalse(tag1.hashCode() == tag2.hashCode());
    }

}