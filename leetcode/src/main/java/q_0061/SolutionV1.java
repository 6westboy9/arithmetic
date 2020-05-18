package q_0061;

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
        System.out.println(ListNode.ofValues(solution.rotateRight(l11, 7)));

    }
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }

        int mod = k % count;
        if (mod == 0) {
            return head;
        } else {
            k = mod;
        }

        ListNode slowPreNode = null;
        ListNode slowNode = null;
        ListNode curPreNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            if (k == 0) {
                slowNode = head;
            }
            slowPreNode = slowNode;
            slowNode = slowNode != null ? slowNode.next : null;

            curPreNode = curNode;
            curNode = curNode.next;
            k--;
        }

        if (slowPreNode != null) {
            slowPreNode.next = null;
        }
        curPreNode.next = head;

        return slowNode;
    }

}
