package q_0206;

import base.ListNode;

import java.util.Stack;

/**
 * @author westboy
 * @since 2020/4/26
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
		System.out.println(ListNode.ofValues(solution.reverseList(node1)));
	}

	/**
	 * 使用栈
	 */
	public ListNode reverseList(ListNode node) {
		Stack<ListNode> stack = new Stack<>();

		while (node != null) {
			stack.add(node);
			node = node.next;
		}

		ListNode head = null;
		ListNode preNode = null;
		while (!stack.isEmpty()) {
			ListNode pop = stack.pop();
			ListNode newNode = new ListNode(pop.val);
			if (preNode != null) {
				preNode.next = newNode;
			} else {
				head = newNode;
			}
			preNode = newNode;
		}
		return head;
	}

}
