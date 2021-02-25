package q_0234;

import base.ListNode;

/**
 * 回文链表
 *
 * @author pengbo
 * @since 2020/11/23
 */
public class SolutionV1 {


    public static void main(String[] args) {

        // 偶数的情况
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(2);
        // ListNode node4 = new ListNode(1);
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;

        // 奇数的情况
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.ofHashes(node1));
        System.out.println(solution.isPalindrome(node1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 第一步骤：寻找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 1-2-2-1   slow=第一个2 fast=第二个2
        // 1-2-3-2-1 slow=3 fast=第二个1

        System.out.println(slow.hashCode() + ":" + slow.val);
        System.out.println(fast.hashCode() + ":" + fast.val);

        // 第二步骤：反转后半部分
        ListNode right = slow.next;
        ListNode rightAfterConvert = reconvert(right);

        System.out.println(ListNode.ofValues(rightAfterConvert));

        // 第三步骤：对比
        ListNode current = head;
        while (rightAfterConvert != null && current != null) {
            if (rightAfterConvert.val != current.val) {
                return false;
            }
            rightAfterConvert = rightAfterConvert.next;
            current = current.next;
        }

        return true;
    }

    private ListNode reconvert(ListNode right) {
        ListNode current = right;
        ListNode post = null;
        ListNode pre = null;
        while (current != null) {
            // 需要暂存
            post = current.next;

            current.next = pre;
            pre = current;

            current = post;
        }

        return pre;
    }
}
