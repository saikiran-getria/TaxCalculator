package com.ria.taxcalculator.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class ItemTest {

    @Test
    public void testConstructor() {
        Item newItem = new Item();
        newItem.setExempted(true);
        newItem.setImported(false);
        newItem.setName("Butter");
        newItem.setPrice(10.0);
        newItem.setQty(1);

        assertEquals("Butter", newItem.getName());

        assertEquals(10.0, newItem.getPrice(), 0.0);

        assertEquals(1, newItem.getQty());

        assertTrue(newItem.isExempted());

        assertFalse(newItem.isImported());
    }
}

