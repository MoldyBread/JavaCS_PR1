package com.company.pacakge;

import com.company.util.Util;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class PackageManager {
    private byte[] data;
    private int encLen;

    public PackageManager(byte[] data)  {
        this.data = data;
        encLen=data.length-16;

    }

    public boolean checkPackage(){
        if(getPart(Util.CRC(Util.subArray(data,0,13)),2)!=sumCRC(14,15)){
            return false;
        }

        return getPart(Util.CRC(Util.subArray(data, 16, encLen)),data.length - 1-16-encLen)
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
