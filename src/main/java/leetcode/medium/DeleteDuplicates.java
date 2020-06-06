package leetcode.medium;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/5/16 15:00
 * @Title 82. 删除排序链表中的重复元素 II
 * @Description //TODO
 **/

public class DeleteDuplicates {

    //执行用时 :1 ms, 在所有 Java 提交中击败了92.48%的用户
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = new ListNode(-1);
        ListNode pre = temp;
        while (head != null) {
            int val = head.val;
            ListNode next = head.next;
            //遍历后继节点，直到节点值不等于val
            while (next != null && next.val == val) {
                next = next.next;
            }
            //后继节点等于head.next说明没有重复，反之重复不添加
            if (next == head.next) {
                pre.next = head;
                pre = pre.next;
            }
            head = next; //移动head节点到下一节点
        }
        pre.next = null; //断链，很重要
        return temp.next;
    }
}
