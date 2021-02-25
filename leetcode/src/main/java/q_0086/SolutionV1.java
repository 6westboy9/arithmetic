package q_0086;

import base.ListNode;

/**
 * 分隔链表
 *
 * @author pengbo
 * @since 2021/2/25
 */
public class SolutionV1 {


    // 输入：head = [1,4,3,2,5,2], x = 3
    // 输出：[1,2,2,4,3,5]

    // 输入：head = [2,1], x = 2
    // 输出：[1,2]

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(4);
        ListNode nodeC = new ListNode(3);
        ListNode nodeD = new ListNode(0);
        ListNode nodeE = new ListNode(2);
        ListNode nodeF = new ListNode(5);
        ListNode nodeG = new ListNode(2);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;
        nodeE.next = nodeF;
        nodeF.next = nodeG;
        System.out.println(ListNode.ofValues(nodeA));

        // ListNode nodeA = new ListNode(2);
        // ListNode nodeB = new ListNode(1);
        // nodeA.next = nodeB;

        SolutionV1 solution = new SolutionV1();
        ListNode res = solution.partition(nodeA, 3);
        System.out.println(ListNode.ofValues(res));
    }

    // [1,4,3,2,5,2]  x=3
    // [1,4,3,2,5,2] cur=1 [1,4,3,2,5,2] 没变
    // [1,4,3,2,5,2] cur=4 [1,4,3,2,5,2] 没变
    // [1,4,3,2,5,2] cur=3 [1,4,3,2,5,2] 没变

    // [1,4,3,2,5,2] cur=2 [1,2,4,3,5,2] 移动

    // [1,2,4,3,5,2] cur=5 [1,2,4,3,5,2] 没变

    // [1,2,4,3,5,2] cur=2 [1,2,2,4,3,5] 移动

    // [2,1] x=2
    // [2,1] cur=2 [2,1]
    // [2,1] cur=2 [1,2]

    public ListNode partition(ListNode head, int x) {

        ListNode minHead = null; // 记录小于 x 的链表头节点
        ListNode minTail = null; // 记录小于 x 的链表尾节点

        ListNode maxHead = null; // 记录大于等于 x 的链表头节点
        ListNode maxTail = null; // 记录大于等于 x 的链表尾节点

        ListNode cur = head;

        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = null;

            if (cur.val >= x) {
                if (maxTail != null) {
                    maxTail.next = cur;
                }
                if (maxHead == null) {
                    maxHead = cur;
                }
                maxTail = cur;
            } else {
                if (minTail != null) {
                    minTail.next = cur;
                }
                if (minHead == null) {
                    minHead = cur;
                }
                minTail = cur;
            }
            cur = nextNode;
        }

        // System.out.println(ListNode.ofValues(maxHead));
        // System.out.println(ListNode.ofValues(minHead));

        // return minHead == null ? maxHead : minHead;
        if (minHead != null) {
            minTail.next = maxHead;
        }
        return minHead != null ? minHead : maxHead;
    }
}
