package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author westboy
 * @since 2020/2/21
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int v) {
		this.val = v;
		this.next = null;
	}

	public ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public static List<Integer> ofValues(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.val);
			node = node.next;
		}
		return list;
	}

	public static List<Integer> ofHashes(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.hashCode());
			node = node.next;
		}
		return list;
	}
}
