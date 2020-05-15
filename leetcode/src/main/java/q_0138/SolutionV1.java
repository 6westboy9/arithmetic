package q_0138;

import base.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author westboy
 * @since 2020/2/21
 */
public class SolutionV1 {
	public static void main(String[] args) {
		Node node1 = new Node(3);
		Node node2 = new Node(3);
		Node node3 = new Node(3);

		node1.next = node2;
		node2.next = node3;
		node2.random = node1;

		printNode(node1);
		SolutionV1 solution = new SolutionV1();
		Node node = solution.copyRandomList(node1);
		printNode(node);

	}

	private static void printNode(Node node1) {
		while (node1 != null) {
			System.out.println("val: " + node1.val + ", hashCode: " + node1.hashCode()
				+ ", nextHashCode: " + (node1.next == null ? null : node1.next.hashCode())
				+ ", randomHashCode: " + (node1.random == null ? null : node1.random.hashCode()));
			node1 = node1.next;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		Map<Node, Node> map = new HashMap<>();
		Node node = head;
		while (node != null) {
			map.put(node, new Node(node.val));
			node = node.next;
		}

		node = head;
		while (node != null) {
			Node nd = map.get(node);
			nd.next = map.getOrDefault(node.next, null);
			nd.random = map.getOrDefault(node.random, null);
			node = node.next;
		}
		return map.get(head);
	}
}
