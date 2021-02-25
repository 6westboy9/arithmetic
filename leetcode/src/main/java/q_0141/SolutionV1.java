package q_0141;

import base.ListNode;

public class SolutionV1 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        // ListNode l14 = new ListNode(4);
        // ListNode l15 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;
        // l13.next = l14;
        // l14.next = l15;

        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.hasCycle(l11));
    }

    public boolean hasCycle(ListNode head) {
        // 链表为空或者只有一个节点
        if (head == null || head.next == null) {
            return false;
        }

        // 慢指针，每次循环向前移动一步
        ListNode slow = head;
        // 快指针，每次循环向前移动两步
        ListNode fast = head;

        boolean ret = false;
        while (true) {
            // 慢指针走一步
            slow = slow.next;

            // 快指针走两步
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            if (fast == null) {
                break;
            }

            // 判断是否重叠
            if (slow.val == fast.val) {
                ret = true;
                break;
            }
        }
        return ret;
    }
}
