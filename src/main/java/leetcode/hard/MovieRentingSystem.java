package leetcode.hard;

import java.util.*;

/**
 * @Author long
 * @Date 2021/10/6 11:14
 * @Title
 * @Description //TODO
 **/

public class MovieRentingSystem {

    public static void main(String[] args) {
    }

    //entries[i] = [shop, movie, price]

    /**
     * (1) 通过movie查找最便宜的五条记录
     * (2) 删除一条entry
     * (3) 恢复一条entry
     * (4) 查找删除的最便宜的五条记录
     */

    // key: movie  value: TreeSet(entry)
    private final Map<Integer, TreeSet<int[]>> movies = new HashMap<>();
    //key: {shop, movie} value: price
    private final Map<int[], Integer> container = new TreeMap<>((a, b) -> {
        if (a[0] == b[0]) return a[1] - b[1];
        return a[0] - b[0];
    });
    //entry
    private final TreeSet<int[]> rents = new TreeSet<>((a, b) -> {
        if (a[2] == b[0]) {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        }
        return a[2] - b[2];
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];
            if (!movies.containsKey(movie)) {
                movies.put(movie, new TreeSet<>((a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }));
            }
            container.put(new int[]{shop, movie}, price);
            movies.get(movie).add(new int[]{price, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        TreeSet<int[]> set = movies.get(movie);
        if (set == null) return res;
        for (int[] entry : set) {
            res.add(entry[1]);
            if (res.size() == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = container.get(new int[]{shop, movie});
        int[] entry = new int[]{shop, movie, price};
        rents.add(entry);
        movies.get(movie).remove(new int[]{price, shop});
    }

    public void drop(int shop, int movie) {
        int price = container.get(new int[]{shop, movie});
        int[] entry = new int[]{shop, movie, price};
        rents.remove(entry);
        movies.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        for (int[] entry : rents) {
            List<Integer> list = new ArrayList<>();
            list.add(entry[0]);
            list.add(entry[1]);
            res.add(list);
            if (res.size() == 5) break;
        }
        return res;
    }
}
