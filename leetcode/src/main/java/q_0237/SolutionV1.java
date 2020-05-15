package q_0237;

import base.ListNode;

/**
 * @author westboy
 * @since 2020/3/3
 */
public class SolutionV1 {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(9);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		SolutionV1 solution = new SolutionV1();
		// ListNode target = new ListNode(5);
		solution.deleteNode(node2);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
