package com.company.entities;

import com.company.pacakge.PackageManager;
import com.company.util.Util;

import java.util.Random;

public class Message {
    private static int number=0;

    private final int currentNumber;
    private final int commandCode;
    private final int userId;
    private final String message;

    private byte[] data;

    public Message(String message){
        Random z = new Random();
        this.message=message;
        userId=z.nextInt()*8;
        commandCode=10+z.nextInt()*50;
        currentNumber=++number;
    }

    public void send() throws Exception {
        byte[] encrypted=Util.encrypt(message);
        data = new byte[16+encrypted.length];
        data[0]=0xD;
        data[1]=0x1;
        fillPart(currentNumber,2,8);
        fillPart(16+data.length,9,13);
        fillPart(Util.CRC(Util.subArray(data,0,13)),14,15);
        System.arraycopy(encrypted,0,data,16,encrypted.length);
        fillPart(Util.CRC(encrypted),encrypted.length+16,data.length-1);


        new PackageManager(data);
    }


    private void fillPart(int number,int start,int end){
        for (int i = start; i <=end ; i++) {
            if(number<=127){
                data[i]=Byte.valueOf(String.valueOf(number));
                break;
            }else{
                data[i]=127;
                number-=127;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Message("123dsdfsfdsfdsfdsfsdfdsfdsfdsfsdf").send();
    }
}
