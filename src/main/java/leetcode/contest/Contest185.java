package leetcode.contest;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/19 9:37
 * @Title
 * @Description //TODO
 **/

public class Contest185 {

    public String reformat(String s) {
        Stack<Character> digit = new Stack<>();
        Stack<Character> letter = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') digit.push(c);
            else letter.push(c);
        }
        if (Math.abs(digit.size() - letter.size()) > 1) return "";
        StringBuilder builder = new StringBuilder();
        while (!digit.isEmpty() && !letter.isEmpty()) {
            builder.append(digit.pop()).append(letter.pop());
        }
        if (!letter.isEmpty()) builder.insert(0, letter.pop());
        if (!digit.isEmpty()) builder.append(digit.pop());
        return builder.toString();
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foodNameSet = new HashSet<>();
        Map<Integer, Table> restaurant = new HashMap<>();
        List<List<String>> output = new LinkedList<>();
        for (List<String> order : orders) {
            String name = order.get(0);
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            foodNameSet.add(foodItem);
            Table table = restaurant.getOrDefault(tableNumber, new Table(tableNumber));
            table.addFood(foodItem);
            restaurant.put(tableNumber, table);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        priorityQueue.addAll(foodNameSet);
        LinkedList<String> foodList = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            foodList.add(priorityQueue.poll());
        }
        output.add(foodList);
        priorityQueue.clear();
        PriorityQueue<Integer> queue = new PriorityQueue<>(restaurant.keySet());
        while (!queue.isEmpty()) {
            int key = queue.poll();
            Table table = restaurant.get(key);
            List<String> list = new LinkedList<>();
            list.add(String.valueOf(key));
            for (String name : foodList) {
                if (table.foodItems.containsKey(name))
                    list.add(table.foodItems.get(name).toString());
                else list.add("0");
            }
            output.add(list);
        }
        foodList.addFirst("Table");
        return output;
    }

    class Table {
        public int id;
        public Map<String, Integer> foodItems;

        public Table(int id) {
            this.id = id;
            this.foodItems = new HashMap<>();
        }

        public void addFood(String foodItem) {
            foodItems.put(foodItem, foodItems.getOrDefault(foodItem, 0) + 1);
        }
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        boolean[] flag = new boolean[n];
        int index = n - 1;
        int count = -1;
        while (index >= 0) {
            if (croakOfFrogs.charAt(index) == 'k' && check(croakOfFrogs, flag, index)) {
                count++;
                index--;
            } else {
                index--;
            }
        }
        return count;
    }

    public boolean check(String croakOfFrogs, boolean[] flag, int index) {
        int count = 0;
        String p = "croak";
        int i = p.length() - 1;
        while (index >= 0) {
            if (flag[index]) {
                index--;
            } else if (croakOfFrogs.charAt(index) != p.charAt(i)) {
                index--;
            } else {
                flag[index] = true;
                index--;
                i--;
                if (i < 0) {
                    i = p.length() - 1;
                    count++;
                }
            }
        }
        return count > 0;
    }


    public static void main(String[] args) {
        Contest185 contest = new Contest185();
        contest.minNumberOfFrogs("croakcroak");
    }
}
