package leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author long
 * @Date 2021/11/21 10:23
 * @Title
 * @Description //TODO
 **/

public class Contest268 {

    public static void main(String[] args) {
        Contest268 c = new Contest268();
        for (int len = 1; len < 10; len++) {
            int x = (int) Math.pow(10, (len - 1) / 2);
            int y = (int) Math.pow(10, (len + 1) / 2);
            System.out.println("############");
            for (int i = x; i < y; i++) {
                long b = i;
                int j;
                if (len % 2 == 1) j = i / 10;
                else j = i;
                for (; j > 0; j /= 10) {
                    b = b * 10 + j % 10;
                }
                System.out.println(b);
            }
        }
    }

    public long kMirror(int k, int n) {
        long ans = 0;
        for (int len = 1; ; len++) {
            int x = (int) Math.pow(10, (len - 1) / 2);
            int y = (int) Math.pow(10, (len + 1) / 2);

            for (int i = x; i < y; i++) {
                long b = i;
                int j;
                if (len % 2 == 1) j = i / 10;
                else j = i;
                for (; j > 0; j /= 10) {
                    b = b * 10 + j % 10;
                }
                String h = Long.toString(b, k);
                if (isMirror(h.toCharArray())) {
                    ans += b;
                    if (--n == 0) {
                        return ans;
                    }
                }
            }
        }
    }

    public boolean isMirror(char[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            if (a[i] != a[j]) return false;
        }
        return true;
    }


    public long kMirror1(int k, int n) {
        long sum = 0;
        long i = 0;
        while (n > 0) {
            long nextInt = nextInt(i);
            if (isMirror(String.valueOf(nextInt))) {
                String convert = convert(k, nextInt);
                if (isMirror(convert)) {
                    sum += nextInt;
                    n--;
                    if (n == 0) return sum;
                }
            }
            i = nextInt;
        }
        return sum;
    }

    public long nextInt(long num) {
        char[] nums = String.valueOf(num).toCharArray();
        int len = nums.length;
        for (int i = len / 2; i >= 0; i--) {
            if (nums[i] != '9') {
                nums[i] += 1;
                if (len - i - 1 != i) {
                    nums[len - i - 1] += 1;
                }
                for (int j = i + 1; j <= len / 2; j++) {
                    nums[j] = '0';
                    nums[len - j - 1] = '0';
                }
                String s = String.valueOf(nums);
                return Long.parseLong(s);
            }
        }
        long ans = 1;
        for (int i = 0; i < len; i++) {
            ans *= 10;
        }
        ans += 1;
        return ans;
    }

    public boolean isMirror(String value) {
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        builder.reverse();
        return value.equals(builder.toString());
    }

    public static String convert(int k, long value) {
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            builder.append(value % k);
            value = value / k;
        }
        builder.reverse();
        return builder.toString();
    }


    static class RangeFreqQuery {

        Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) return 0;
            int l = binarySearch(list, left);
            int r = binarySearch(list, right);
            if (list.get(r) < left || list.get(l) > right) {
                return 0;
            }
            if (list.get(r) > right) {
                return r - l;
            }
            return r - l + 1;
        }

        private int binarySearch(List<Integer> list, int value) {
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) > value) {
                    right = mid;
                } else if (list.get(mid) < value) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }

    }

    public int wateringPlants(int[] plants, int capacity) {
        int sum = 0;
        int n = plants.length;
        int remains = capacity;
        int cur = -1;
        int i = 0;
        while (i < n) {
            if (remains >= plants[i]) {
                sum += i - cur;
                remains -= plants[i];
                cur = i;
                i++;
            } else {
                remains = capacity;
                sum += cur + 1;
                cur = -1;
            }
        }
        return sum;
    }


    public int maxDistance(int[] colors) {
        int max = 0;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num + 1))
                max = Math.max(max, map.get(num + 1) + map.get(num));
            if (map.containsKey(num - 1))
                max = Math.max(max, map.get(num - 1) + map.get(num));
        }
        return max;
    }


}
