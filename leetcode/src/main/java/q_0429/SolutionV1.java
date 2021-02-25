package q_0429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 叉树的层序遍历，见 {@link q_0429.SolutionV1}
 * N 叉树的后序遍历，见 {@link q_0590.SolutionV1}
 * N 叉树的前序遍历，见 {@link q_0589.SolutionV1}
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * @author pengbo
 * @since 2021/2/20
 */
public class SolutionV1 {

    public static void main(String[] args) {
        Node node1 = newNode(1);

        Node node2 = newNode(2);
        Node node3 = newNode(3);
        Node node4 = newNode(4);
        Node node5 = newNode(5);

        node1.withChildren(node2, node3, node4, node5);

        Node node6 = newNode(6);
        Node node7 = newNode(7);
        Node node8 = newNode(8);
        Node node9 = newNode(9);
        Node node10 = newNode(10);

        node3.withChildren(node6, node7);
        node4.withChildren(node8);
        node5.withChildren(node9, node10);

        Node node11 = newNode(11);
        Node node12 = newNode(12);
        Node node13 = newNode(13);

        node7.withChildren(node11);
        node8.withChildren(node12);
        node9.withChildren(node13);

        Node node14 = newNode(14);
        node11.withChildren(node14);

        //                                    1
        //                               /  /   \  \
        //                              2  3     4   5
        //                                / \    |  / \
        //                               6  7    8 9   10
        //                                  |    | |
        //                                  11  12 13
        //                                  |
        //                                  14

        SolutionV1 solution = new SolutionV1();
        List<List<Integer>> res = solution.levelOrder(node1);

        for (List<Integer> row : res) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        levelOrder(root, res, level);
        return res;
    }

    private void levelOrder(Node node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }

        res.get(level++).add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                levelOrder(child, res, level);
            }
        }
    }


    private static Node newNode(int i) {
        Node node = new Node();
        node.val = i;
        return node;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        public void withChild(Node child) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(child);
        }

        public void withChildren(Node... children) {
            Arrays.asList(children).forEach(this::withChild);
        }

    };
}
