package q_0144;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(2);
		rightTreeNode.left = new TreeNode(3);


		root.right = rightTreeNode;
		SolutionV3 v3 = new SolutionV3();
		System.out.println(v3.preorderTraversal(root));
	}

	/**
	 * 方法二：非递归法二
	 *
	 * @param root 二叉树的根节点
	 * @return 前序遍历结果
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();

		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				res.add(cur.val);
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return res;
	}
}
