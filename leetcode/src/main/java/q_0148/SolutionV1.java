package q_0148;

import base.ListNode;

public class SolutionV1 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(3);
        ListNode l15 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        System.out.println(ListNode.ofValues(l11));
        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.ofValues(solution.sortList(l11)));
    }

    // 要求时间复杂度为 O(nlogn)
    public ListNode sortList(ListNode head) {
        // 第一步：使用快慢指针确定链表的中点，并将链表从中点切分成两部分
        if (head == null || head.next == null) {
            return head;
        }

        // 4 - 2 - 1 - 3      中点为 1
        // 4 - 2 - 1 - 3 - 5  中点为 1
        ListNode slow = head;    // 慢指针，遍历结束的时候刚好处于链表从中点
        ListNode fast = head;    // 快指针，遍历结束的时候为 null 或者 next 为 null
        ListNode preSlow = null; // 记录 slow 节点的前驱节点

        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // System.out.println(slow.val + "," + preSlow.val);

        // 上述 head == null || head.next == null 判断已经保证此处 preSlow 不可能为 null
        // 切割成两部分
        preSlow.next = null;

        // 第二步：二路归并两个链表
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return twoWayMerge(l1, l2);
    }

    private ListNode twoWayMerge(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head; // 临时节点必须有，用来记录 head 链表最后一个节点
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                temp.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                temp.next = listNode2;
                listNode2 = listNode2.next;
            }
            temp = temp.next;
        }

        temp.next = listNode1 == null ? listNode2 : listNode1;
        return head.next;
    }

}
