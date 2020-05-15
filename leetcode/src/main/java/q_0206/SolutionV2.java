package q_0206;

import base.ListNode;

/**
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
		System.out.println(ListNode.toValList(solution.reverseList(node1)));
	}

	public ListNode reverseList(ListNode node) {
		ListNode preNode = null;
		ListNode postNode;
		while (node != null) {
			postNode = node.next;
			node.next = preNode;
			preNode = node;
			node = postNode;
		}
		return preNode;
	}

}
