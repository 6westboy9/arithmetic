package q_0019;

import base.ListNode;

/**
 * 删除链表的倒数第 N 个节点
 *
 * @author pengbo
 * @since 2020/11/23
 */
public class SolutionV1 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SolutionV1 solution = new SolutionV1();

        System.out.println(ListNode.ofValues(node1));
        System.out.println(ListNode.ofValues(solution.removeNthFromEnd(node1, 2)));

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 临时遍历节点指针（先走）
        ListNode current = head;
        // 目标节点（n=0 后开始从头走，当 current 遍历完成时，target 指向的就是目标元素节点）
        ListNode target =  null;
        // 目标节点的前驱节点
        ListNode preTarget = null;

        while (current != null) {
            // 先找到目标元素，n=0 后开始从头走，当 current 遍历完成时，target 指向的就是目标元素节点
            // 此处先尽心 --n，为什么呢？想想，如果我需要查找倒数第 1 个元素，也就是最后一个元素，此时 n=1，所以判断条件为 --n=0
            // 此时 current 指向的是第一个元素，target 指向的也是第一个元素
            // 下次循环，current 指向第二个元素，第一次循环找到的 target 才会赋值 preTarget，在 --n==0 后循环时，才会 target=target.next
            if (--n == 0) {
                target = head;
            } else if (target != null) {
                preTarget = target;
                target = target.next;
            }
            current = current.next;
        }

        // 没有找到目标元素
        if (target == null) {
            return null;
        }

        if (preTarget == null) { // 目标元素为头节点
            head = head.next;
        } else {
            preTarget.next = target.next; // 目标元素为非头节点
        }
        target = null;

        return head;
    }
}
