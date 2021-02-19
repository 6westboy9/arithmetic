package q_0206;

import base.ListNode;

/**
 * 反转链表
 *
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV2 {
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

        SolutionV2 solution = new SolutionV2();
        System.out.println(ListNode.ofValues(solution.reverseList(node1)));
    }

    // 1->2->3->4->5->NULL
	// 5->4->3->2->1->NULL

    public ListNode reverseList(ListNode node) {
    	// 反转后链表的前驱节点
        ListNode preNode = null;
        ListNode postNode;
        while (node != null) {
        	// 先使用 postNode 存储需要遍历的下一个节点
            postNode = node.next;

            // 先设置当前节点的后继节点为已经反转后的链表的前驱节点
            node.next = preNode;
            // 反转后的链表前驱节点设置为当前节点
            preNode = node;

            // 首尾照应，设置遍历的下一个节点
            node = postNode;
        }
        return preNode;
    }

}
