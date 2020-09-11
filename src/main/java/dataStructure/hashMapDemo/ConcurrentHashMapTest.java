package dataStructure.hashMapDemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: long
 * @Date: 2020/8/16 15:19
 * @Title
 * @Description:
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("2", "s");
        HashMap<String, String> hashMap = new HashMap<>(32);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(25);
        map.put("s", "s");
        StringBuilder builder = new StringBuilder();
    }
}
