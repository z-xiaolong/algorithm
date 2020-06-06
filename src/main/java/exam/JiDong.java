package exam;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/18 18:57
 * @Title
 * @Description //TODO
 **/

public class JiDong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[][] rectangles = new int[6 * T][2];
        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i][0] = in.nextInt();
            rectangles[i][1] = in.nextInt();
        }
        for (int i = 0; i < T; i++) {
            if (check(rectangles, i * 6)) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean check(int[][] rectangles, int index) {
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < index + 6; i++) {
            set.add(rectangles[i][0]);
            set.add(rectangles[i][1]);
        }
        if (set.size() > 3) return false;
        if (set.size() == 1) return true;
        Map<Integer, Integer> hashMap = new HashMap<>();
        if (set.size() == 3) {
            for (int i = index; i < index + 6; i++) {
                int x = rectangles[i][0];
                int y = rectangles[i][1];
                if (x == y) return false;
                hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
                hashMap.put(y, hashMap.getOrDefault(y, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int value = entry.getValue();
                if (value != 4) return false;
            }
        } else if (set.size() == 2) {
            int count = 0;
            for (int i = index; i < index + 6; i++) {
                int x = rectangles[i][0];
                int y = rectangles[i][1];
                if (x == y) count++;
            }
            if (count != 2) return false;
        }
        return true;
    }


    public static void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] consumers = new int[n][2];
        int count = 1;
        for (int i = 0; i < consumers.length; i++) {
            consumers[i][0] = in.nextInt();
            consumers[i][1] = in.nextInt();
        }
        Arrays.sort(consumers, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        for (int i = 0; i < consumers.length - 1; i++) {
            if (consumers[i][1] > consumers[i + 1][0]) {
                consumers[i + 1][0] = consumers[i][0];
                consumers[i + 1][1] = Math.max(consumers[i + 1][1], consumers[i][1]);
                count++;
            }
        }
        System.out.println(count);
    }
}
