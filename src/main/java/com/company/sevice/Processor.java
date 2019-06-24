package com.company.sevice;

import com.company.entitiy.Message;
import com.company.sevice.implementation.MessageGeneratorImpl;


public class Processor extends Thread{
    private static Sender sender;


    public Processor(Sender sender){
        this.sender=sender;
    }

    @Override
    public void run() {
        super.run();

        try {
            process(new MessageGeneratorImpl().generate());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void process(Message message) throws Exception {
        sender.send(message.getData(),null);
    }

    public static void main(String[] args) {
        Sender sender = new Sender();
        new Processor(sender).start();
        new Processor(sender).start();
        new Processor(sender).start();
    }

}
