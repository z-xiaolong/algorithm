package blockchain;

/**
 * @Author long
 * @Date 2020/1/9 11:02
 * @Title
 * @Description //TODO
 **/

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long number = 0;
        for (int i = 0; i < Integer.MAX_VALUE >> 16; i++) {
            number = i * 2 - i;
            for (int j = 0; j < Integer.MAX_VALUE >> 17; j++) {
                number = j * i;
                for (int k = 0; k < 1; k++) {
                    number = k * i * j;
                }
            }
        }
        System.out.println(number);
        System.out.printf("耗时 Time: %s seconds \n", (float) (System.currentTimeMillis() - startTime) / 1000);
    }
}
