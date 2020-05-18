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

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public static List<Integer> ofValues(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.val);
			node = node.next;
		}
		return list;
	}

}
