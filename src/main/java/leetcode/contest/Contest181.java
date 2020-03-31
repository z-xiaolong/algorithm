package leetcode.contest;

/**
 * @Author long
 * @Date 2020/3/22 9:39
 * @Title
 * @Description //TODO
 **/

public class Contest181 {


    //5364. 按既定顺序创建目标数组
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for (int i = 0; i < target.length; i++) {
            insert(target, index[i], nums[i]);
        }
        return target;
    }

    public void insert(int[] target, int index, int value) {
        int pre = target[index];
        for (int i = index + 1; i < target.length; i++) {
            int temp = target[i];
            target[i] = pre;
            pre = temp;
        }
        target[index] = value;
    }


    //5178. 四因数
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += divisor(num);
        }
        return sum;
    }

    public int divisor(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i != num) {
                    count += 2;
                    sum += i + (num / i);
                } else {
                    count++;
                    sum += i;
                }
            }
        }
        if (count == 4) {
            return sum;
        }
        return 0;
    }


    //5366. 检查网格中是否存在有效路径
    public boolean hasValidPath(int[][] grid) {
        return step(grid, 0, 0);
    }


    public boolean step(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        int current = grid[i][j];
        grid[i][j] = -1;
        if (current == 1) {
            if (j + 1 < grid[0].length && (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                return step(grid, i, j + 1);
            } else if (j - 1 >= 0 && (grid[i][j - 1] == 4 || grid[i][j - 1] == 6 || grid[i][j - 1] == 1)) {
                return step(grid, i, j - 1);
            }
        } else if (current == 2) {
            if (i + 1 < grid.length && (grid[i + 1][j] == 5 || grid[i + 1][j] == 6 || grid[i + 1][j] == 2)) {
                return step(grid, i + 1, j);
            } else if (i - 1 >= 0 && (grid[i - 1][j] == 3 || grid[i - 1][j] == 4 || grid[i - 1][j] == 2)) {
                return step(grid, i - 1, j);
            }
        } else if (current == 3) {
            if (i + 1 < grid.length && (grid[i + 1][j] == 5 || grid[i + 1][j] == 6 || grid[i + 1][j] == 2)) {
                return step(grid, i + 1, j);
            } else if (j - 1 >= 0 && (grid[i][j - 1] == 4 || grid[i][j - 1] == 6 || grid[i][j - 1] == 1)) {
                return step(grid, i, j - 1);
            }
        } else if (current == 4) {
            if (i + 1 < grid.length && (grid[i + 1][j] == 5 || grid[i + 1][j] == 6 || grid[i + 1][j] == 2)) {
                return step(grid, i + 1, j);
            } else if (j + 1 < grid[0].length && (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                return step(grid, i, j + 1);
            }
        } else if (current == 5) {
            if (i - 1 >= 0 && (grid[i - 1][j] == 3 || grid[i - 1][j] == 4 || grid[i - 1][j] == 2)) {
                return step(grid, i - 1, j);
            } else if (j - 1 >= 0 && (grid[i][j - 1] == 4 || grid[i][j - 1] == 6 || grid[i][j - 1] == 1)) {
                return step(grid, i, j - 1);
            }
        } else if (current == 6) {
            if (i - 1 >= 0 && (grid[i - 1][j] == 3 || grid[i - 1][j] == 4 || grid[i - 1][j] == 2)) {
                return step(grid, i - 1, j);
            } else if (j + 1 < grid[0].length && (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)) {
                return step(grid, i, j + 1);
            }
        }
        return false;
    }

    //5367. 最长快乐前缀


    //暴力法，超时
    public String longestPrefix(String s) {
        int length = s.length();
        if (length == 1) {
            return "";
        }
        String res = "";
        for (int i = 1; i < length; i++) {
            String pre = s.substring(0, i);
            String next = s.substring(length - i, length);
            if (pre.equals(next)) {
                res = pre;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Contest181 contest = new Contest181();
        int[][] nums = new int[][]{{1, 1, 1, 1, 1, 1, 3}};
        contest.longestPrefix("aaaaa");
    }
}
