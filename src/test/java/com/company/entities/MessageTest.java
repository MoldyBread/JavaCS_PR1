package com.company.entities;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MessageTest {
    @Test
    public void shouldReturnTrue() throws Exception {
        Message message = new Message("123NoFalsePlease123");

        assertTrue(message.send());
    }
}