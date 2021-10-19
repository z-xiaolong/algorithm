package leetcode.contest;

/**
 * @Author long
 * @Date 2021/9/19 10:21
 * @Title
 * @Description //TODO
 **/

public class Contest259 {

    public static void main(String[] args) {

    }

    class DetectSquares {
        private final int[][] points;

        public DetectSquares() {
            points = new int[1010][1010];
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            points[x][y]++;
        }

        public int count(int[] point) {
            int count = 0;
            int x = point[0];
            int y = point[1];
            for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
                count += points[i][j] * points[x][j] * points[i][y];
            }
            for (int i = x - 1, j = y + 1; i >= 0 && j <= 1000; i--, j++) {
                count += points[i][j] * points[x][j] * points[i][y];
            }
            for (int i = x + 1, j = y - 1; i <= 1000 && j >= 0; i++, j--) {
                count += points[i][j] * points[x][j] * points[i][y];
            }
            for (int i = x + 1, j = y + 1; i <= 1000 && j <= 1000; i++, j++) {
                count += points[i][j] * points[x][j] * points[i][y];
            }
            return count;
        }
    }


    public int sumOfBeauties(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], max[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > max[i - 1] && nums[i] < min[i + 1]) {
                sum += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                sum++;
            }
        }
        return sum;
    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String op : operations) {
            if (op.contains("+")) ans++;
            else ans--;
        }
        return ans;
    }
}
