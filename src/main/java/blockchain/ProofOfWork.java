package blockchain;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.math.BigInteger;

/**
 * @Author long
 * @Date 2020/1/5 18:56
 * @Title
 * @Description //TODO
 **/

public class ProofOfWork {

    private static String str = DigestUtils.sha256Hex("long");
    public static final int TARGET_BITS = 18;

    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();
        long nonce = 0;
        BigInteger targetValue = BigInteger.ONE.shiftLeft((256 - TARGET_BITS));
        String shaHex = "";
        shaHex.hashCode();
        while (nonce < Long.MAX_VALUE) {
            byte[] data = prepareData(nonce);
            shaHex = DigestUtils.sha256Hex(data);
            if (new BigInteger(shaHex, 16).compareTo(targetValue) < 0) {
                System.out.println();
                System.out.printf("耗时 Time: %s seconds \n", (float) (System.currentTimeMillis() - startTime) / 1000);
                System.out.printf("当前Hash: %s \n", shaHex);
                break;
            } else {
                nonce++;
            }
        }
        System.out.println(shaHex);
    }

    private static byte[] prepareData(long nonce) {
        byte[] prevBlockHashBytes = str.getBytes();
        return ArrayUtils.addAll(prevBlockHashBytes, String.valueOf(nonce).getBytes());
    }
}
