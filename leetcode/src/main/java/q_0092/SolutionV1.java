package q_0092;

import base.ListNode;

/**
 * 反转列表 II
 *
 * @author pengbo
 * @since 2021/2/25
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

        System.out.println(ListNode.ofValues(node1));
        SolutionV1 solution = new SolutionV1();
        ListNode res = solution.reverseBetween(node1, 2, 4);
        System.out.println(ListNode.ofValues(res));
    }

    // 参考题解：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shi-pin-jiang-jie-yi-ci-bian-li-bu-kai-pi-on-/
    //
    // 输入: 1->2->3->4->5->NULL, m = 2, n = 4
    // 输出: 1->4->3->2->5->NULL
    //
    // 1 ≤ m ≤ n ≤ 链表长度
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 辅助节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode cur = newHead;
        if (head == null || head.next == null) {
            return head;
        }

        // before 为第 left-1 个节点
        // after 为第 right+1 个节点
        ListNode before = null, after = null;
        for (int i = 1; i <= left - 1; i++) {
            cur = cur.next;
        }
        before = cur;

        // System.out.println("第 left-1 个节点：" + before.val);

        cur = cur.next;
        // System.out.println("第 left 个节点：" + cur.val);

        before.next = null; // 防止死循环，先切断
        ListNode reverseHead = null; // 反转后的链表头节点
        ListNode temp = null;
        for (int i = left; i <= right; i++) {
            if (cur == null) {
                break;
            }
            if (i == right) {
                after = cur.next;
                // System.out.println("第 right+1 个节点：" + after.val);
            }

            // 链表反转核心逻辑
            temp = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = temp;
        }


        before.next = reverseHead; // 将
        if (reverseHead != null) {
            // 遍历反转链表，找到尾节点
            while (reverseHead.next != null) {
                reverseHead = reverseHead.next;
            }
            reverseHead.next = after;
        }
        return newHead.next;
    }
}
