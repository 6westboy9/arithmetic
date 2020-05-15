package q_0110;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {
	public static void main(String[] args) {
		//               3
		//              / \
		//             9   20
		//                /  \
		//               15   7

		TreeNode root = new TreeNode(3);

		TreeNode rightTreeNode = new TreeNode(20);
		rightTreeNode.left = new TreeNode(15);
		rightTreeNode.right = new TreeNode(7);

		root.left = new TreeNode(9);
		root.right = rightTreeNode;
		SolutionV2 v2 = new SolutionV2();
		System.out.println(v2.isBalanced(root));
	}

	public boolean isBalanced(TreeNode root) {
		return depth(root) != -1;
	}

	/**
	 * 获取当前节点
	 * @param root
	 * @return
	 */
	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = depth(root.left);
		if (left == -1) {
			return -1;
		}

		int right = depth(root.right);
		if (right == -1) {
			return -1;
		}

		return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
	}
}
