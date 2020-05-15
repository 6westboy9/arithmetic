package q_0021;

import base.ListNode;

public class SolutionV1 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.toValList(solution.mergeTwoLists(l11, l21)));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ListNode head = null;
        // ListNode temp = null;
        // while (l1 != null && l2 != null) {
        //     if (l1.val <= l2.val) {
        //         if (temp == null) {
        //             head = l1;
        //             temp = head;
        //         } else {
        //             temp.next = l1;
        //             temp = temp.next;
        //         }
        //         l1 = l1.next;
        //     } else {
        //         if (temp == null) {
        //             head = l2;
        //             temp = head;
        //         } else {
        //             temp.next = l2;
        //             temp = temp.next;
        //         }
        //         l2 = l2.next;
        //     }
        // }
        //
        // if (l1 == null) {
        //     if (temp == null) {
        //         head = l2;
        //     } else {
        //         temp.next = l2;
        //     }
        // }
        //
        // if (l2 == null) {
        //     if (temp == null) {
        //         head = l1;
        //     } else {
        //         temp.next = l1;
        //     }
        // }
        // return head;


        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // if (l1 != null) {
        //     prev.next = l1;
        // }
        //
        // if (l2 != null) {
        //     prev.next = l2;
        // }
        prev.next = l1 != null ? l1 : l2;
        return preHead.next;
    }

}
