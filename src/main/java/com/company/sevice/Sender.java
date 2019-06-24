package com.company.sevice;

import java.net.InetAddress;

public class Sender {
    private static int state=1;

    Receiver receiver = new Receiver(null);

    public synchronized void send(byte[] data, InetAddress inetAddress){
        while (state==2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        state=2;

        receiver.setData(data);
        receiver.receive();

        state=1;
        notifyAll();




    }
}
