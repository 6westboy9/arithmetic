package q_0061;

import base.ListNode;

public class SolutionV2 {
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

        SolutionV2 solution = new SolutionV2();
        System.out.println(ListNode.toValList(solution.rotateRight(l11, 7)));

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }


        int n = 1;
        ListNode tempNode = head;
        // 注意是从 tempNode.next 开始的，所以 n 从 1 开始计数，目的是找到尾节点
        while (tempNode.next != null) {
            n++;
            tempNode = tempNode.next;
        }

        // 找到尾节点构造闭环
        tempNode.next = head;


        ListNode curNode = head;
        //
        // 寻找新的链表的头节点，新的链表的头节点是第 n - (k % n) + 1 个节点，新的链表的尾节点是第 n - (k % n) 个节点
        int i = 1;
        while (i < n - k % n) { // 当 i = n - k % n 时，curNode 为新的链表的尾节点，而新的 链表的头节点为 curNode.next
            curNode = curNode.next;
            i++;
        }

        ListNode newHead = curNode.next;
        // 断开环
        curNode.next = null;
        return newHead;
    }
}
