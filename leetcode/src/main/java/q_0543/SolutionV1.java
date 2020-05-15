package q_0543;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV1 {

	public static void main(String[] args) {
		//               1
		//              / \
		//             2   3
		//                / \
		//               4   5

		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(3);
		rightTreeNode.left = new TreeNode(4);
		rightTreeNode.right = new TreeNode(5);

		root.left = new TreeNode(2);
		root.right = rightTreeNode;
		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.diameterOfBinaryTree(root));
		// System.out.println(v1.depth(root));
	}

	private int ans = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return ans;
	}

	private int depth(TreeNode node) {
		if (node == null) return 0;
		int l = depth(node.left);
		int r = depth(node.right);
		ans = Math.max(ans, l + r);
		return Math.max(l, r) + 1;
	}
}
