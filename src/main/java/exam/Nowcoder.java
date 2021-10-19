package exam;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/13 19:57
 * @Title
 * @Description //TODO
 **/

public class Nowcoder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int R = in.nextInt();
        int dis = in.nextInt();
        int[] power = new int[n + 1];
        int max = R;
        for (int i = 1; i <= n; i++) {
            power[i] = in.nextInt();
            max = Math.max(max, power[i]);
        }
        List<Integer>[] map = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            map[x].add(y);
            map[y].add(x);
        }
        if (!valid(map, power, max + 1, dis, n)) {
            System.out.println(-1);
            return;
        }
        int left = Math.max(R, power[n]);
        int right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(map, power, mid, dis, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - R);
    }


    public static boolean valid(List<Integer>[] map, int[] power, int r, int dis, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] flag = new boolean[n + 1];
        flag[1] = true;
        while (!queue.isEmpty() && dis > 0) {
            int size = queue.size();
            while (size > 0) {
                int cur = queue.poll();
                for (int next : map[cur]) {
                    if (power[next] < r && !flag[next]) {
                        if (next == n) return true; //到达目的点
                        queue.add(next); //可以通过
                        flag[next] = true;
                    }
                }
                size--;
            }
            dis--;
        }
        return false;
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        int[] cnt = new int[26];
        int[] dp = new int[n];
        int[] prev = new int[26];
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            cnt[index]++;
            if (cnt[index] >= 2) {
                dp[i] = dp[prev[index]];
                dp[i] += prev[index] - cnt[index] + 2;
            }
            prev[index] = i;
        }
        long ans = 0;
        for (int j : dp) {
            ans += j;
        }
        System.out.println(ans);
    }

    public static boolean valid(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < n - 1 && nums[left] < nums[left + 1]) {
            left++;
        }
        while (right > 0 && nums[right] < nums[right - 1]) {
            right--;
        }
        return left == right;
    }

    //1 2 3 4 5 6 5 4 3 2 1
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
