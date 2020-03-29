package com.txzhang.springcloud.oauth2client.test;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ClassName：TestHex
 * @Author：txzhang
 * @Date：2020/3/18—14:39
 * @Description：
 **/
@Slf4j
public class TestHex {

    private final static String[] hexArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static byte[] initCommand(int num, int calibrationValue) {
        String hex = Integer.toHexString(calibrationValue);
        log.info("16进制：{}", hex);
        String prefix_hex = hex.substring(0, 2);
        String suffix_hex = hex.substring(2);
        int i = Integer.parseInt(suffix_hex, 16) & 0xff;
        log.info("顶顶顶顶, {}", (byte) i);
        log.info("高8位是：{}", prefix_hex);
        log.info("低8位是：{}", suffix_hex);
        byte[] result = new byte[]{0x06, 0x43, 0x00};
        return result;
    }

    public static void main(String[] args) {
//        int a = Integer.parseInt("21", 16);
//        int b = Integer.parseInt("43", 16);
//        int c = Integer.parseInt("3", 16);
//        int d = Integer.parseInt("0", 16);
//        int e = Integer.parseInt("c", 16);
//        int f = Integer.parseInt("3a", 16);
//        int cs = ~(a + b + c + d + e + f) + 1;
//        System.out.println(cs);
//        String hex = Integer.toHexString(cs);
//        System.out.println(hex);
//        BigInteger bigInteger = new BigInteger(hex, 16);
//        System.out.println(bigInteger.intValue());


//        System.out.println((byte) 0x13e);

//        String s = "45.5";
//        float v = new Float(s) * 100;
//        int result = new Float(v).intValue();
//        System.out.println(result);

//        byte[] bytes = "c6ddc2".getBytes();
//        byte[] ffs = Util.hexToByte("c6ddc2");
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(ffs));
//
//        int x = ~50005;
//        String x1 = Integer.toHexString(x);
//        byte[] x2 = Util.hexStringToBytes(x1);
//        System.out.println(x2);

        System.out.println((byte) 203);

    }
}
