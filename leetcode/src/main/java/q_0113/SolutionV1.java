package q_0113;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
		//          / \     / \
		//         7   2   5   1

		TreeNode root = new TreeNode(5);

		TreeNode rightTreeNode = new TreeNode(8);
		rightTreeNode.left = new TreeNode(13);
		TreeNode rightTreeNode1 = new TreeNode(4);
		rightTreeNode1.left = new TreeNode(5);
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
		System.out.println(v1.pathSum(root, 22));
	}


	List<List<Integer>> list = new ArrayList<>();
	ArrayList<Integer> inner = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return list;
		}

		sum -= root.val;
		inner.add(root.val);
		if (root.left == null && root.right == null && sum == 0) {
			// 注意：需要拷贝一份
			list.add(new ArrayList<>(inner));
		}

		if (root.left != null) {
			pathSum(root.left, sum);
		}

		if (root.right != null) {
			pathSum(root.right, sum);
		}

		// 注意：从列表中删除
		inner.remove(inner.size() - 1);

		return list;
	}
}
