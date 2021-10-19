package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author long
 * @Date 2021/9/9 10:48
 * @Title
 * @Description //TODO
 **/

public class FullJustify {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = 0;
            int j = i;
            while (j < n && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j++;
            }
            ans.add(wordItem(words, i, j - 1, len, maxWidth));
            i = j;
        }
        return ans;
    }

    public String wordItem(String[] words, int i, int j, int len, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        int blank = maxWidth - len;
        if (j == words.length - 1) {
            return lastLine(words, i, j, len, maxWidth);
        }
        builder.append(words[i]);
        if (j == i) {
            builder.append(fillBlank(blank));
            return builder.toString();
        }
        int subBlank = blank / (j - i);
        int mod = blank % (j - i);
        i++;
        while (i <= j) {
            builder.append(fillBlank(subBlank));
            if (mod > 0) {
                builder.append(' ');
                mod--;
            }
            builder.append(words[i]);
            i++;
        }
        return builder.toString();
    }

    public String lastLine(String[] words, int i, int j, int len, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        while (i <= j) {
            builder.append(words[i]);
            if (len < maxWidth) {
                builder.append(' ');
                len++;
            }
            i++;
        }
        builder.append(fillBlank(maxWidth - len));
        return builder.toString();
    }

    public String fillBlank(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }
}
