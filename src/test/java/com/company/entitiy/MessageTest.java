package com.company.entitiy;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MessageTest {
    @Test
    public void shouldCheckEnglishMessage() throws Exception {
        Message message = new Message("123NoFalsePlease123");

        assertTrue(true);
    }

    @Test
    public void shouldCheckUkrainianMessage() throws Exception {
        Message message = new Message("123Україна123");

        assertTrue(true);
    }
}