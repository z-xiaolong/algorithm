package blockchain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Author long
 * @Date 2020/1/8 21:09
 * @Title
 * @Description //TODO
 **/

public class HashCompute {

    private static int length = 32;
    private static byte[] value = new byte[length];
    private static String encName = "SHA-256";

    public static void plusOne(){

    }

    public static String Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }



    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static void main(String args[]) {
        String s = "123";
        System.out.println(Arrays.toString(s.getBytes()));
        System.out.println();
        String str = "l";
        String shaHex = "";
        long nonce = 0;
        long startTime = System.currentTimeMillis();
        long times = 0;
        System.out.println(String.valueOf(Long.MAX_VALUE).getBytes().length);
        while (nonce < Long.MAX_VALUE) {
            shaHex = Encrypt(String.valueOf(nonce));
            times++;
            if (check(shaHex)) {
                System.out.println(shaHex);
                break;
            } else {
                nonce++;
            }
        }
        System.out.printf("耗时 Time: %s seconds \n", (float) (System.currentTimeMillis() - startTime) / 1000);
        System.out.println(times);
    }

    public static final int TARGET_BITS = 4;

    public static boolean check(String s) {
        for (int i = 0; i < TARGET_BITS; i++) {
            if (s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
