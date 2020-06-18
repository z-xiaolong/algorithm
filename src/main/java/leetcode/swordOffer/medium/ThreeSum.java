package leetcode.swordOffer.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author long
 * @Date 2020/6/12 9:47
 * @Title
 * @Description //TODO
 **/

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();
        if (nums == null || nums.length < 3) return output;
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[0] * nums[length - 1] <= 0) {
            for (int i = 0; i < length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return output;
    }


    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!outStack.isEmpty()) {
                return outStack.pop();
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        int shortest = shorter * k;
        for (int i = 0; i < result.length; i++) {
            result[i] = shortest;
            shortest += longer - shorter;
        }
        return result;
    }

}
