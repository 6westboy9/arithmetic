package q_0002;

import base.ListNode;

public class SolutionV1 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.toValList(solution.addTwoNumbers(l11, l21)));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v = 0;
        int m;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || v != 0) {
            int v1 = 0;
            int v2 = 0;

            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int k = v1 + v2 + v;
            m = k % 10;
            v = k / 10;

            if (head == null) {
                head = new ListNode(m);
                tail = head;
            } else {
                tail.next = new ListNode(m);
                tail = tail.next;
            }
        }
        return head;
    }
}
