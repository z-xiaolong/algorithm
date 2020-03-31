package leetcode.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/3/23 9:40
 * @Title 876. 链表的中间结点
 * @Description //TODO
 **/

public class MiddleNode {


    //执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        temp = head;
        count = count / 2;
        while (count > 0) {
            temp = temp.next;
            count--;
        }
        return temp;
    }
}
