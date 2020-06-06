package leetcode.medium;

/**
 * @Author long
 * @Date 2020/4/19 9:41
 * @Title LCP 08. 剧情触发时间
 * @Description //TODO
 **/

public class GetTriggerTime {

    //反向二分查找：
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = requirements.length;
        int[] result = new int[n];
        for (int i = 1; i < increase.length; i++) {
            increase[i][0] += increase[i - 1][0];
            increase[i][1] += increase[i - 1][1];
            increase[i][2] += increase[i - 1][2];
        }
        for (int i = 0; i < requirements.length; i++) {
            result[i] = binarySearch(increase, requirements[i]);
        }
        return result;
    }

    public int binarySearch(int[][] increase, int[] requirement) {
        if (requirement[0] == 0 && requirement[1] == 0 && requirement[2] == 0) return 0;
        int left = 0;
        int right = increase.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (increase[mid][0] >= requirement[0] && increase[mid][1] >= requirement[1] && increase[mid][2] >= requirement[2]) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (index == -1) return -1;
        return index + 1;
    }
}
