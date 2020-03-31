package leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author long
 * @Date 2020/2/28 10:34
 * @Title
 * @Description //TODO
 **/

public class Contest175 {


    /**
     * create by long on 2020/2/28
     *
     * @description 1346. 检查整数及其两倍数是否存在
     */
    public boolean checkIfExist(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-10, -20, -8};
        String s = "leetcode";
        String t = "practice";
        Contest175 contest175 = new Contest175();
        contest175.minSteps(s, t);
    }

    /**
     * create by long on 2020/2/28
     *
     * @description 1347. 制造字母异位词的最小步骤数
     */
    public int minSteps(String s, String t) {
        int count = 0;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int c : chars) {
            if (c < 0) {
                count += -c;
            }
        }
        return count;
    }


    public int minStepsI(String s, String t) {
        int count = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (hashMap.getOrDefault(t.charAt(i), -1) < 1) {
                count++;
            } else {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
            }
        }
        return count;
    }


    //1348. 推文计数
    class TweetCounts {

        public TweetCounts() {

        }

        public void recordTweet(String tweetName, int time) {

        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            return null;
        }
    }


}
