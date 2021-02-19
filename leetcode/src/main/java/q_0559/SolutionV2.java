package q_0559;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pengbo.wang
 * @date 2020/07/28 11:23 上午
 */
public class SolutionV2 {
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

        SolutionV2 solution = new SolutionV2();
        System.out.println(solution.maxDepth(node1));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current == null || current.children == null) {
                    continue;
                }
                for (Node child : current.children) {
                    queue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }
}


