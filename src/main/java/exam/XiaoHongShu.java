package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: long
 * @Date: 2020/8/30 19:58
 * @Title
 * @Description:
 */
public class XiaoHongShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int[][] dp = new int[20][20];
        int[] chose = new int[20];
        System.out.println(4);
    }



    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] res;
        int count = 1;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            res = splitMsg(line);
            for (String re : res) {
                System.out.println(String.format("msg%d:%s", count, re));
                count++;
            }
        }
    }

    public static String[] splitMsg(String text) {
        int MAX_SIZE = 1024;
        char[] tempArray = new char[MAX_SIZE];
        int lastParagraphEnd = 0, lastSentenceEnd = 0, pos = 0, lastTextPos = 0;
        ArrayList<String> ret = new ArrayList<>();
        char[] textChars = text.toCharArray();
        char[] splited;
        for (int textpos = 0; textpos < textChars.length; ) {
            char c = textChars[textpos++];
            tempArray[pos] = c;
            if (c == '\n') {
                lastParagraphEnd = pos;
            } else if ('.' == c || '!' == c) {
                lastSentenceEnd = pos;
            }
            pos++;
            if (pos == MAX_SIZE) {
                int splitPos = lastParagraphEnd > 0 ? lastParagraphEnd : lastSentenceEnd;
                splited = new char[splitPos + 1];
                System.arraycopy(tempArray, 0, splited, 0, splitPos + 1);

                ret.add(new String(splited));
                lastParagraphEnd = 0;
                lastSentenceEnd = 0;
                pos = 0;
                textpos = lastTextPos + splitPos + 1;
                lastTextPos = textpos;
            }
        }
        if (pos > 0) {
            splited = new char[pos];

            System.arraycopy(tempArray, 0, splited, 0, pos);
            ret.add(new String(splited));
        }
        return ret.toArray(new String[]{});
    }
}
