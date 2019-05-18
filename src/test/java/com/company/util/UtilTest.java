package com.company.util;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void shouldEncryptAndDecrypt() throws Exception {
        String actual = Util.decrypt(Util.encrypt("My string"));
        String expected = "My string";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCRC16() {
        int actual = Util.crc(new byte[]{1, 2, 3});
        int expected = 41232;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSubArray() {
        byte[] actual = Util.subArray(new byte[]{1,2,3,4,5},1,3);
        byte[] expected = {2,3,4};

        Assert.assertArrayEquals(expected, actual);
    }

}