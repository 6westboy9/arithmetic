package q_0023;

import base.ListNode;

public class SolutionV1 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);

        l31.next = l32;


        ListNode[] listNodes = {l11, l21, l31};
        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.toValList(solution.mergeKLists(listNodes)));
    }

    // 1-4-5
    // 1-3-4
    // 2-6
    // headNode
    // preNode
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;

        while (true) {

            int minIndex = -1;
            ListNode minNode = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minNode = lists[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) {
                break;
            }

            preNode.next = minNode;
            preNode = preNode.next;
            lists[minIndex] = lists[minIndex].next;
        }
        return headNode.next;
    }
}
