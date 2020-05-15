package q_0111;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/1/17
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
		System.out.println(v1.minDepth(root));
	}

	/**
	 * 递归法
	 *
	 * @param root 二叉树节点
	 * @return 当前二叉树节点的最小深度
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
}
