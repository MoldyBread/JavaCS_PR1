package com.company.sevice;

import com.company.util.Util;

import javax.crypto.Cipher;

public class Encryptor {
    public byte[] encrypt(String message) throws Exception {
        Util.cipher.init(Cipher.ENCRYPT_MODE, Util.aesKey);
        return Util.cipher.doFinal(message.getBytes());
    }
}
