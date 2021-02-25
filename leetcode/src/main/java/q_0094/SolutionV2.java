package q_0094;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历，见 {@link q_0094.SolutionV1}
 * 二叉树的前序遍历，见 {@link q_0144.SolutionV1}
 * 二叉树的后序遍历，见 {@link q_0145.SolutionV1}
 *
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode rightTreeNode = new TreeNode(3);
        rightTreeNode.left = new TreeNode(6);

        TreeNode leftTreeNode = new TreeNode(2);
        leftTreeNode.left = new TreeNode(4);
        leftTreeNode.right = new TreeNode(5);

        root.left = leftTreeNode;
        root.right = rightTreeNode;
        SolutionV2 v2 = new SolutionV2();
        System.out.println(v2.inorderTraversal(root));
    }

    /**
     * 方法二：迭代法
     *
     * @param root 二叉树的根节点
     * @return 中序遍历结果
     *
     * 左中右
     */

    //            1
    //         2    3
    //       4  5  6

    // 左中右
    // 中序遍历结果：4,2,5,1,6,3
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
