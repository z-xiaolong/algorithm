package leetcode.medium.greedy;

/**
 * @Author long
 * @Date 2020/2/24 21:54
 * @Title 1353. 最多可以参加的会议数目
 * @Description 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，
 * 表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。
 * 注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 **/

public class MaxEvents {

    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();
        int[][] events = new int[][]{{1, 2}, {1, 2}, {1, 2}, {1, 6}, {1, 2}, {1, 2}};
        maxEvents.maxEvents(events);
    }

    public int maxEvents(int[][] events) {
        int count = events.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            if (events[i][1] > max) {
                max = events[i][1];
            }
        }
        int[] days = new int[max + 1];
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            for (int j = start; j <= end; j++) {
                days[j]++;
            }
        }
        while (check(days)) {
            int index = findMin(days);
            int[] event = findEvent(events, index);
            for (int j = event[0]; j <= event[1]; j++) {
                if(days[j] > 0){
                    days[j]--;
                }
            }
            days[index] = 0;
            sum++;
        }
        return sum;
    }

    public boolean check(int[] days) {
        for (int num : days) {
            if (num != 0) {
                return true;
            }
        }
        return false;
    }

    public int[] findEvent(int[][] events, int day) {
        for (int[] event : events) {
            if (event[0] <= day && event[1] >= day) {
                return event;
            }
        }
        return null;
    }

    public int findMin(int[] days) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > 0 && days[i] < min) {
                min = days[i];
                index = i;
            }
        }
        return index;
    }
}
