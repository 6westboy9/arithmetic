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
    	// 反转后链表的头节点
        ListNode head = null;
        // 借助临时节点用于遍历
        ListNode temp;
        while (node != null) {
        	// 先使用 postNode 存储需要遍历的下一个节点
            temp = node.next;

            // ======================== 核心步骤 ========================
            node.next = head;  // 设置当前节点的后继节点为反转链表的头节点
            head = node;       // 更新反转链表的头节点
            // =========================================================

            // 首尾照应，设置遍历的下一个节点
            node = temp;
        }
        return head;
    }

}
