package leetcode.swordOffer.easy;

import leetcode.entity.ListNode;

import java.util.List;

/**
 * @Author long
 * @Date 2020/3/14 21:22
 * @Title 面试题52. 两个链表的第一个公共节点
 * @Description 输入两个链表，找出它们的第一个公共节点。
 **/

public class GetIntersectionNode {

    //链表相交法  L1 + C + L2 + C = L2 + C + L1 + C  => L1 + C + L2 = L2 + C + L1
    //在相交点汇合   执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA != null) {
                tempA = tempA.next;
            } else {
                tempA = headB;
            }
            if (tempB != null) {
                tempB = tempB.next;
            } else {
                tempB = headA;
            }
        }
        return tempA;
    }

    //执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
    public ListNode getIntersectionNodeI(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            countA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            countB++;
        }
        tempA = headA;
        tempB = headB;
        while (countA > countB) {
            tempA = tempA.next;
            countA--;
        }
        while (countA < countB) {
            tempB = tempB.next;
            countB--;
        }
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}
