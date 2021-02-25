package q_0024;

import base.ListNode;

/**
 * 两两交换链表中的节点
 *
 * @author pengbo
 * @since 2021/2/22
 */
public class SolutionV1 {

    public static void main(String[] args) {
        // ListNode node1 = new ListNode(1);
        // ListNode node2 = new ListNode(2);
        // ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        //
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        // ListNode node1 = new ListNode(1);
        // ListNode node1 = null;

        SolutionV1 solution = new SolutionV1();
        System.out.println(ListNode.ofValues(solution.swapPairs(node1)));
    }

    // 输入：head = [1,2,3,4]
    // 输出：[2,1,4,3]
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode curPost = null;

        // 已经遍历过的尾部节点
        ListNode tail = null;
        boolean flag = false;

        // 每次遍历两个元素
        while (cur != null) {
            curPost = cur.next;
            if (curPost != null) {
                ListNode next = curPost.next;

                // 反转
                cur.next = null;
                curPost.next = cur;

                if (tail != null) {
                    tail.next = curPost;
                }

                tail = cur;

                // 设置头节点
                if (!flag) {
                    head = curPost;
                    flag = true;
                }

                cur = next;
            } else {
                if (tail != null) {
                    tail.next = cur;
                }
                break;
            }
        }
        return head;
    }

}
