package q_0019;

import base.ListNode;

/**
 * 删除链表的倒数第 N 个节点
 *
 * @author pengbo
 * @since 2020/11/23
 */
public class SolutionV1 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SolutionV1 solution = new SolutionV1();

        System.out.println(ListNode.ofValues(node1));
        System.out.println(ListNode.ofValues(solution.removeNthFromEnd(node1, 2)));

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode target =  null;
        ListNode preTarget = null;

        while (current != null) {

            // 先找到目标元素
            if (--n == 0) {
                target = head;
            } else if (target != null) {
                // 找到目标元素后续遍历操作
                preTarget = target;
                target = target.next;
            }

            current = current.next;
        }

        // 没有找到目标元素
        if (target == null) {
            return null;
        }

        if (preTarget == null) {
            head = head.next;
        } else {
            preTarget.next = target.next;
        }
        target = null;

        return head;
    }
}
