package q_0102;

import base.TreeNode;

import java.util.*;

/**
 * @author westboy
 * @since 2020/1/20
 */
public class SolutionV1 {
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

		SolutionV1 v1 = new SolutionV1();
		System.out.println(Arrays.deepToString(v1.levelOrderV2(root).toArray()));
	}

	public List<List<Integer>> levelOrderV1(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return Collections.emptyList();
		}

		List<TreeNode> treeNodes = new ArrayList<>();
		treeNodes.add(root);

		while (!treeNodes.isEmpty()) {
			ArrayList<Integer> integers = new ArrayList<>();
			// 一个临时 list 存放下一层 node
			ArrayList<TreeNode> treeNodeTmp = new ArrayList<>();
			for (TreeNode treeNode : treeNodes) {
				integers.add(treeNode.val);
				if (treeNode.left != null) {
					treeNodeTmp.add(treeNode.left);
				}
				if (treeNode.right != null) {
					treeNodeTmp.add(treeNode.right);
				}
			}
			// 替换临时 list
			treeNodes = treeNodeTmp;
			res.add(integers);
		}
		return res;
	}

	public List<List<Integer>> levelOrderV2(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> levels = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levels.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			// 区别点：头插入
			result.addFirst(levels);
		}
		return result;
	}
}
