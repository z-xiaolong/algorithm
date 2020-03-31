package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author long
 * @Date 2020/3/1 12:55
 * @Title 1349. 参加考试的最大学生数
 * @Description //TODO
 **/

public class MaxStudents {


    private List<HashMap<String, Integer>> hashMaps;

    //DP
    public int maxStudents(char[][] seats) {
        hashMaps = new ArrayList<>(seats.length);
        return 0;
    }

    public int DP(String[] seat, int index) {
        if (index >= seat.length) {
            return 0;
        }
        int max = hashMaps.get(index).getOrDefault(seat, 0);
        if (max != 0) {
            return max;
        }
        String seatOne = seat[index];
        for (int i = 0; i < seatOne.length(); i++) {
            
        }

        return max;
    }

    //回溯法，超时
    public int maxStudentsI(char[][] seats) {
        return backtrack(0, seats, 0, 0);
    }

    public int backtrack(int count, char[][] seats, int i, int j) {
        if (j >= seats[0].length) {
            return backtrack(count, seats, i + 1, 0);
        }
        if (i >= seats.length) {
            return count;
        }
        if (check(seats, i, j)) {
            setSeats(seats, i, j);
            int max1 = backtrack(count + 1, seats, i, j + 2);
            reset(seats, i, j);
            int max2 = backtrack(count, seats, i, j + 1);
            return Math.max(max1, max2);
        }
        return backtrack(count, seats, i, j + 1);
    }

    public void reset(char[][] seats, int i, int j) {
        if (j + 1 < seats[0].length && seats[i][j + 1] == '0') {
            seats[i][j + 1] = '.';
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '0') {
            seats[i][j - 1] = '.';
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '0') {
            seats[i - 1][j - 1] = '.';
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '0') {
            seats[i - 1][j + 1] = '.';
        }
    }

    public void setSeats(char[][] seats, int i, int j) {
        if (j + 1 < seats[0].length && seats[i][j + 1] == '.') {
            seats[i][j + 1] = '0';
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '.') {
            seats[i][j - 1] = '0';
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '.') {
            seats[i - 1][j - 1] = '0';
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '.') {
            seats[i - 1][j + 1] = '0';
        }
    }

    public boolean check(char[][] seats, int i, int j) {
        if (seats[i][j] != '.') {
            return false;
        }
        if (j + 1 < seats[0].length && seats[i][j + 1] == '1') {
            return false;
        }
        if (j - 1 >= 0 && seats[i][j - 1] == '1') {
            return false;
        }
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '1') {
            return false;
        }
        if (j + 1 < seats[0].length && i - 1 >= 0 && seats[i - 1][j + 1] == '1') {
            return false;
        }
        return true;
    }
}
