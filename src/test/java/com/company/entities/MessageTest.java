package com.company.entities;

import org.junit.Assert;
import org.junit.Test;

public class MessageTest {
    @Test
    public void shouldReturnTrue() throws Exception {
        Message message = new Message("123NoFalsePleas123");

        Assert.assertTrue(message.send());
    }
}