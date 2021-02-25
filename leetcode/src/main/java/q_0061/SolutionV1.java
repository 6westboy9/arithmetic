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

    /**
     * 易理解
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode tempNode = head;
        int len = 0; // 计算链表的长度
        while (tempNode != null) {
            len++;
            tempNode = tempNode.next;
        }

        int mod = k % len;
        if (mod == 0) {
            return head;
        } else {
            k = mod;
        }

        // k 为

        ListNode slowPreNode = null;
        ListNode slowNode = null;
        ListNode curPreNode = null;
        ListNode curNode = head;

        // curNode 为快指针
        // slowNode 为慢指针，与 curNode 相差 k 个元素
        // slowPreNode 为慢指针前驱结点
        // curPreNode 为快指针前驱节点
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
