package q_0023;

import base.ListNode;

public class SolutionV3 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);

        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);

        l31.next = l32;


        ListNode[] listNodes = {l11, l21, l31};
        SolutionV3 solution = new SolutionV3();
        System.out.println(ListNode.ofValues(solution.mergeKLists(listNodes)));
    }

    // 推荐
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int k = lists.length;
        // 一开始有 K 个链表，啥时候合并完只剩下一个链表即合并完成
        while (k > 1) {
            int idx = 0;

            // for 循环作用每一层的两两合并
            // idx 记录下一次循环的索引

            // l0 \
            //     l0
            // l1 /  \
            //        l0
            // l2 \  /  \
            //     l1    l0
            // l3 /  \  /
            //        l1
            // l4 \  /
            //     l2

            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return preHead.next;
    }
}
