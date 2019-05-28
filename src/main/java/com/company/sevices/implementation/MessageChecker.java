package com.company.sevices.implementation;

import com.company.util.Util;

public class MessageChecker {
    private byte[] data;
    private int encLen;

    public MessageChecker(byte[] data)  {
        this.data = data;
        encLen=data.length-16;

    }

    public boolean checkPackage(){
        if(getPart(Util.crc(Util.subArray(data,0,13)),2)!=sumCRC(14,15)){
            return false;
        }

        return getPart(Util.crc(Util.subArray(data, 16, encLen)),data.length - 1-16-encLen)
                == sumCRC(16 + encLen, data.length - 1);
    }

    private int sumCRC(int start,int end){
        int res=0;
        for (int i = start; i <=end; i++) {
            res+=data[i];
        }
        return res;
    }

    private int getPart(int number,int count){
        int res=0;
        for (int i = 0; i <count ; i++) {
            if(number<=127){
                res+=Byte.valueOf(String.valueOf(number));
                break;
            }else{
                res+=127;
                number-=127;
            }
        }
        return res;
    }

}
