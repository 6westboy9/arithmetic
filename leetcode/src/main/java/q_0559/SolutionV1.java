package q_0559;

import java.util.*;

/**
 * N 叉树的最大深度
 *
 * @author pengbo.wang
 * @date 2020/07/28 10:51 上午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        Node node5 = new Node();
        node5.val = 5;
        Node node6 = new Node();
        node6.val = 6;

        List<Node> node3Children = new ArrayList<>();
        node3Children.add(node5);
        node3Children.add(node6);

        Node node3 = new Node();
        node3.val = 3;
        node3.children = node3Children;

        Node node2 = new Node();
        node2.val = 2;
        Node node4 = new Node();
        node4.val = 4;

        List<Node> node1Children = new ArrayList<>();
        node1Children.add(node3);
        node1Children.add(node2);
        node1Children.add(node4);

        Node node1 = new Node();
        node1.val = 1;
        node1.children = node1Children;

        // Node.print(node1);

        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.maxDepth(node1));

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            return 1;
        } else {
            int max = 0;
            for (Node item : root.children) {
                max = Math.max(max, maxDepth(item));
            }
            return max + 1;
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
