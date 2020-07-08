package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/6/21 9:50
 * @Title
 * @Description //TODO
 **/

public class Contest194 {

    //5440. 数组异或操作
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + i * 2;
        }
        return result;
    }


    //5441. 保证文件名唯一
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (hashMap.containsKey(names[i])) {
                names[i] = getName(names[i], hashMap);
            }
            hashMap.put(names[i], 1);
        }
        return names;
    }

    public String getName(String name, Map<String, Integer> map) {
        int i = map.get(name);
        String temp = name;
        name = temp + "(" + i + ")";
        while (map.containsKey(name)) {
            i++;
            name = temp + "(" + i + ")";
        }
        map.put(temp,i);
        return name;
    }


    //5442. 避免洪水泛滥
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int right = 0;
        while (right < rains.length) {
            if (rains[right] > 0) {
                if (map.containsKey(rains[right])) {
                    int before = map.get(rains[right]);

                }
                map.put(rains[right], right);
            } else if (rains[right] == 0) {
                list.addLast(right);
            }
            right++;
        }
        while (list.size() > 0) {
            res[list.pollFirst()] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
