package q_0102;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author westboy
 * @since 2020/1/20
 */
public class SolutionV2 {

	public static void main(String[] args) {
		//               3
		//              / \
		//             9   20
		//                /  \
		//               15   7

		// [
		//   [3],
		//   [9,20],
		//   [15,7]
		// ]
		TreeNode root = new TreeNode(3);

		TreeNode rightTreeNode = new TreeNode(20);
		rightTreeNode.left = new TreeNode(15);
		rightTreeNode.right = new TreeNode(7);

		root.left = new TreeNode(9);
		root.right = rightTreeNode;

		SolutionV2 v2 = new SolutionV2();
		System.out.println(Arrays.deepToString(v2.levelOrder(root).toArray()));
	}

	List<List<Integer>> levels = new ArrayList<>();

	public void helper(TreeNode node, int level) {
		if (levels.size() == level) {
			levels.add(new ArrayList<>());
		}

		if (node.left != null) {
			helper(node.left, level + 1);
		}

		if (node.right != null) {
			helper(node.right, level + 1);
		}

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return levels;
		}
		helper(root, 0);
		return levels;
	}
}
