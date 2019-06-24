package com.company.sevice.implementation;

import com.company.entitiy.Message;
import com.company.sevice.MessageGenerator;

import java.util.Random;

public class MessageGeneratorImpl implements MessageGenerator {
    @Override
    public Message generate() {
        String[] toGen = {"1 1","2","3 1"};
        Random z = new Random();
        return new Message(toGen[z.nextInt(toGen.length)]);
    }
}
