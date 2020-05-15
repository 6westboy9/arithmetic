package q_0142;

import base.ListNode;

public class SolutionV1 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(0);
        ListNode l14 = new ListNode(-4);

        // 3 -> 2 -> 0 -> 4
        //       \________|

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l12;

        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.detectCycle(l11).val);
    }

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

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
