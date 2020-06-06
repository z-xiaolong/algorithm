package leetcode.easy;

import leetcode.entity.ListNode;

/**
 * @Author long
 * @Date 2020/4/27 11:15
 * @Title 237. 删除链表中的节点
 * @Description //TODO
 **/

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
