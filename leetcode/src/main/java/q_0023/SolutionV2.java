package q_0023;

import base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionV2 {
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
        SolutionV2 solution = new SolutionV2();
        System.out.println(ListNode.ofValues(solution.mergeKLists(listNodes)));
    }

    // 利用优先级队列
    public ListNode mergeKLists(ListNode[] listNodes) {
        // 创建小根堆
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));
        // 先把每个排序链表的头节点塞入队列
        for (ListNode node : listNodes) {
            // 需要加限制
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode headNode = new ListNode(-1);
        ListNode preNode = headNode;
        while (!queue.isEmpty()) {
            // 根据小根堆的特性，取出的第一个即为当前所有排序链表中值最小的节点
            ListNode minNode = queue.poll();
            preNode.next = minNode;
            preNode = minNode;
            // 取出最小值的节点排序链表之后，需要将排序链表的后继节点塞入队列
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return headNode.next;
    }


}
