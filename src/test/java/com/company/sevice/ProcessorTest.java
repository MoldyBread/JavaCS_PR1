package com.company.sevice;

import org.junit.Test;

public class ProcessorTest {

    @Test
    public void shouldMultiThreadSend() throws InterruptedException {
        Sender sender = new Sender();

        for (int i = 0; i < 5; i++) {
            new Processor(sender).start();
        }
    }
}