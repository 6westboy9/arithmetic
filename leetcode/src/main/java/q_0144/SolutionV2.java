package q_0144;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(2);
		rightTreeNode.left = new TreeNode(3);


		root.right = rightTreeNode;
		SolutionV2 v2 = new SolutionV2();
		System.out.println(v2.preorderTraversal(root));
	}

	/**
	 * 方法二：非递归法一
	 *
	 * @param root 二叉树的根节点
	 * @return 前序遍历结果
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		stack.push(root);

		while (!stack.empty()) {
			TreeNode node = stack.pop();

			res.add(node.val);
			// 前序遍历，所以要先压入右节点
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}
}
