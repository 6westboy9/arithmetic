package q_0160;

import base.ListNode;

/**
 * @author westboy
 * @since 2020/2/21
 */
public class SolutionV1 {
	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		ListNode headB = new ListNode(3);

		ListNode head1 = new ListNode(9);
		ListNode head2 = new ListNode(1);
		ListNode head3 = new ListNode(2);
		ListNode head4 = new ListNode(4);

		head1.next = head2;
		head2.next = head3;
		head3.next = head4;

		// headA 0 - 9 - 1 - 2 - 4
		// headB         3 /
		headA.next = head1;
		headB.next = head3;

		SolutionV1 solution = new SolutionV1();
		ListNode node = solution.getIntersectionNode(headA, headB);
		System.out.println(node == null ? null : node.val);

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// 第一步骤：先遍历 headA/headB，分别计算出 headA/headB 的链表长度和 headA/headB 的尾节点
		int aLength = 0;
		ListNode aTailNode = null;
		ListNode nodeA = headA;
		while (nodeA != null) {
			aLength++;
			aTailNode = nodeA;
			nodeA = nodeA.next;
		}

		int bLength = 0;
		ListNode bTailNode = null;
		ListNode nodeB = headB;
		while (nodeB != null) {
			bLength++;
			bTailNode = nodeB;
			nodeB = nodeB.next;
		}

		System.out.println("headA.len=" + aLength + ", headA.tail.val=" + aTailNode.val);
		System.out.println("headB.len=" + bLength + ", headB.tail.val=" + bTailNode.val);


		// 第二步骤：找到 headA 和 headB 长度相同时，长链表的起始位置
		if (aLength > bLength) {
			for (int i = 0; i < aLength - bLength; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < bLength - aLength; i++) {
				headB = headB.next;
			}
		}

		System.out.println("headA.val=" + headA.val);
		System.out.println("headB.val=" + headB.val);


		// 第三步骤：尾节点相同说明相交
		if (aTailNode == bTailNode) {
			while (headA != headB) {
				headA = headA.next;
				headB = headB.next;
			}
			// System.out.println("aLength: " + aLength + ", aTailNode: " + (aTailNode == null ? null : aTailNode.val) + ", headA: " + headA.val);
			// System.out.println("bLength: " + bLength + ", bTailNode: " + (bTailNode == null ? null : bTailNode.val) + ", headB: " + headB.val);
			return headA;
		}
		return null;
	}
}
