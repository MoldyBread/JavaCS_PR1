package com.company.sevice;

import com.company.util.Util;

import javax.crypto.Cipher;

public class Decryptor {
    public String decrypt(byte[] message) throws Exception {
        Util.cipher.init(Cipher.DECRYPT_MODE, Util.aesKey);
        return new String(Util.cipher.doFinal(message));
    }
}
