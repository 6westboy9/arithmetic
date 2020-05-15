package q_0112;

import base.TreeNode;

/**
 * @author westboy
 * @since 2020/2/5
 */
public class SolutionV1 {
	public static void main(String[] args) {
		//               5
		//              / \
		//             4   8
		//            /   / \
		//           11  13  4
		//          / \       \
		//         7   2       1

		TreeNode root = new TreeNode(5);

		TreeNode rightTreeNode = new TreeNode(8);
		rightTreeNode.left = new TreeNode(13);
		TreeNode rightTreeNode1 = new TreeNode(4);
		rightTreeNode1.right = new TreeNode(1);
		rightTreeNode.right = rightTreeNode1;

		TreeNode leftTreeNode = new TreeNode(4);
		TreeNode leftTreeNode1 = new TreeNode(11);
		leftTreeNode1.left = new TreeNode(7);
		leftTreeNode1.right = new TreeNode(2);
		leftTreeNode.left = leftTreeNode1;

		root.left = leftTreeNode;
		root.right = rightTreeNode;
		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.hasPathSum(root, 22));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		sum -= root.val;
		if (root.left == null && root.right == null) {
			return sum == 0;
		}

		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}


}
