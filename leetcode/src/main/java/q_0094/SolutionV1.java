package q_0094;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历，见 {@link q_0094.SolutionV1}
 * 二叉树的前序遍历，见 {@link q_0144.SolutionV1}
 * 二叉树的后序遍历，见 {@link q_0145.SolutionV1}
 *
 * @author westboy
 * @since 2020/1/17
 */
public class SolutionV1 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(3);
		rightTreeNode.left = new TreeNode(6);

		TreeNode leftTreeNode = new TreeNode(2);
		leftTreeNode.left = new TreeNode(4);
		leftTreeNode.right = new TreeNode(5);

		root.left = leftTreeNode;
		root.right = rightTreeNode;
		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.inorderTraversal(root));
	}

	/**
	 * 方法一：递归法
	 *
	 * @param root 二叉树的根节点
	 * @return 中序遍历结果
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		inorderTraversalV1(root, res);
		return res;
	}


	public void inorderTraversalV1(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}

		inorderTraversalV1(root.left, res);
		res.add(root.val);
		inorderTraversalV1(root.right, res);
	}
}
