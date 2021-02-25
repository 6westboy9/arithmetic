package q_0142;

import base.ListNode;

public class SolutionV1 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(0);
        ListNode l14 = new ListNode(-4);

        // 3 -> 2 -> 0 -> 4  返回链表开始入环的第一个节点
        //       \________|

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l12;

        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.detectCycle(l11).val);
    }

    // https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/xiang-xi-tu-jie-ken-ding-kan-de-ming-bai-by-xixili/
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;

            // 快慢指针第一次相遇时
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
