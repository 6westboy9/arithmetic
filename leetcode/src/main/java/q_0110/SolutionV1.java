package q_0110;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/1/19
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
		System.out.println(v1.isBalanced(root));
	}


	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	/**
	 * 获取当前节点的最大深度
	 *
	 * @param node 当前节点
	 * @return 当前节点的最大深度
	 */
	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(depth(node.left), depth(node.right)) + 1;
	}
}
