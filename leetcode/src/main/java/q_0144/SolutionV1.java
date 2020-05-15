package q_0144;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author westboy
 * @since 2020/1/17
 */
public class SolutionV1 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(2);
		rightTreeNode.left = new TreeNode(3);


		root.right = rightTreeNode;
		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.preorderTraversal(root));
	}

	/**
	 * 方法一：递归法
	 *
	 * @param root 二叉树的根节点
	 * @return 前序遍历结果
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preorderTraversalV1(root, res);
		return res;
	}


	public void preorderTraversalV1(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}

		res.add(root.val);
		preorderTraversalV1(root.left, res);
		preorderTraversalV1(root.right, res);
	}
}
