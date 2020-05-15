package q_0112;

import base.TreeNode;

import java.util.Stack;

/**
 * @author westboy
 * @since 2020/2/5
 */
public class SolutionV2 {
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
		SolutionV2 v2 = new SolutionV2();
		System.out.println(v2.hasPathSum(root, 22));
	}

	private class Item {

		private TreeNode node;
		private int remain;

		public Item(TreeNode node, int remain) {
			this.node = node;
			this.remain = remain;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		Stack<Item> stack = new Stack<>();
		stack.push(new Item(root, sum));

		while (!stack.isEmpty()) {
			Item item = stack.pop();
			int remain = item.remain - item.node.val;

			if (remain == 0
				&& item.node.left == null
				&& item.node.right == null) {
				return true;
			}

			if (item.node.left != null) {
				stack.push(new Item(item.node.left, remain));
			}
			if (item.node.right != null) {
				stack.push(new Item(item.node.right, remain));
			}
		}

		return false;
	}
}
