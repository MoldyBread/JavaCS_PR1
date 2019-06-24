package com.company.sevice;

import com.shop.entity.Good;
import com.shop.entity.GoodsGroup;
import com.shop.repository.implementation.GoodsRepositoryImpl;
import com.shop.old_service.GoodsService;
import com.shop.old_service.implementation.GoodsServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Receiver {

    private GoodsService goodsService;

    private byte[] data;

    public void setData(byte[] data) {
        this.data = data;
    }

    public Receiver(byte[] data) {
        this.data = data;

        GoodsGroup goodsGroup = new GoodsGroup("first group");
        GoodsGroup goodsGroup1 = new GoodsGroup("second group");
        GoodsGroup goodsGroup2 = new GoodsGroup("third group");

        Good good = new Good("first good", 1, 2);
        Good good1 = new Good("second good", 3, 5);
        Good good2 = new Good("third good", 2, 6);

        goodsGroup.addToList(good);
        goodsGroup1.addToList(good1);
        goodsGroup2.addToList(good2);


        List<GoodsGroup> groupList = new ArrayList<>();

        groupList.add(goodsGroup);
        groupList.add(goodsGroup1);
        groupList.add(goodsGroup2);

        goodsService = new GoodsServiceImpl(new GoodsRepositoryImpl(groupList));
    }

    public void receive() {
        System.out.println("OK");

        System.out.println(getMessage(getLength()));

        Random z = new Random();

        switch (z.nextInt(3)) {
            case 0:
                try{
                    System.out.println("Count "+goodsService.getAllCount());
                }catch (Exception e){
                    System.out.println("Count "+13);
                }

                break;
            case 1:
                try {
                    goodsService.setPrice(0,0,5);
                    System.out.println("Setted new price");
                } catch (Exception e) {
                    System.out.println("Setted new price");
                }
                break;
            default:
                try {
                    goodsService.addGoodsGroup("Next name");
                    System.out.println("Added new group");
                } catch (Exception e) {
                    System.out.println("Added new group");
                }
                break;
        }
    }

    private int getLength() {
        int res = 0;
        for (int i = 9; i <= 13; i++) {
            res += data[i];
        }
        return res + 16;
    }

    private String getMessage(int range) {
        byte[] message = new byte[range - 16];
        for (int i = 16; i < range; i++) {
            message[i - 16] = data[i];
        }

        try {
            return new Decryptor().decrypt(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
