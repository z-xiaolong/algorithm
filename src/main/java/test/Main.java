package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author long
 * @Date 2020/3/20 16:20
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] cards = new int[n][2];
        for (int i = 0; i < n; i++) {
            cards[i][0] = in.nextInt();
            cards[i][1] = in.nextInt();
        }
        //System.out.println(getMaxMoney(cards));
    }


}
