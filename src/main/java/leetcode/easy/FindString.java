package leetcode.easy;

/**
 * @Author long
 * @Date 2020/7/23 9:54
 * @Title
 * @Description //TODO
 **/

public class FindString {

    public static void main(String[] args) {
        String[] words = new String[]{"DirNnILhARNS hOYIFB", "SM ", "YSPBaovrZBS", "evMMBOf", "mCrS", "oRJfjw gwuo", "xOpSEXvfI"};
        findString(words,"mCrS");
    }

    public static int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int newMid = mid;
            if ("".equals(words[newMid])) {
                while (newMid < words.length && "".equals(words[newMid])) {
                    newMid++;
                }
                if (newMid == words.length) {
                    newMid = mid - 1;
                    while (newMid >= 0 && "".equals(words[newMid])) {
                        newMid--;
                    }
                }
                if (newMid < 0) return -1;
            }
            int compare = words[newMid].compareTo(s);
            if (compare < 0) {
                left = mid + 1;
            } else if (compare > 0) {
                right = mid - 1;
            } else {
                return newMid;
            }
        }
        return -1;
    }


}
