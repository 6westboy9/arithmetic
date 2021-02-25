package q_0145;

import base.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历，见 {@link q_0094.SolutionV2}
 * 二叉树的前序遍历，见 {@link q_0144.SolutionV2}
 * 二叉树的后序遍历，见 {@link q_0145.SolutionV2}
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
		System.out.println(v2.postorderTraversal(root));
	}

	/**
	 * 方法二：迭代法
	 *
	 * @param root 二叉树的根节点
	 * @return 后序遍历结果
	 */

	//            1
	//         2    3
	//       4  5  6

	// 左右中
	// 后序遍历结果：4,5,2,6,3,1
	public List<Integer> postorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> res = new LinkedList<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.addFirst(node.val);
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.right != null) {
				stack.add(node.right);
			}
		}
		return res;
	}
}
