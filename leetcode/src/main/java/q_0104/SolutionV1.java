package q_0104;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/1/18
 */
public class SolutionV1 {

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

		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.maxDepth(root));
	}

	/**
	 * 递归法
	 *
	 * @param root 二叉树节点
	 * @return 当前二叉树节点的最大深度
	 */
	private int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
