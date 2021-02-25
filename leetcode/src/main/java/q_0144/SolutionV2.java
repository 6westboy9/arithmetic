package q_0144;

import base.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历，见 {@link q_0094.SolutionV2}
 * 二叉树的前序遍历，见 {@link q_0144.SolutionV2}
 * 二叉树的后序遍历，见 {@link q_0145.SolutionV2}
 *
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {

	public static void main(String[] args) {
		// TreeNode root = new TreeNode(1);
		// TreeNode rightTreeNode = new TreeNode(2);
		// rightTreeNode.left = new TreeNode(3);
		// root.right = rightTreeNode;

		TreeNode root = new TreeNode(1);

		TreeNode rightTreeNode = new TreeNode(3);
		rightTreeNode.left = new TreeNode(6);

		TreeNode leftTreeNode = new TreeNode(2);
		leftTreeNode.left = new TreeNode(4);
		leftTreeNode.right = new TreeNode(5);

		root.left = leftTreeNode;
		root.right = rightTreeNode;

		SolutionV2 v2 = new SolutionV2();
		System.out.println(v2.preorderTraversal(root));
	}

	/**
	 * 方法二：迭代法（推荐，易理解）
	 *
	 * @param root 二叉树的根节点
	 * @return 前序遍历结果
	 */

	//            1
	//         2    3
	//       4  5  6

	// 中左右
	// 前序遍历结果：1,2,4,5,3,6
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		Stack<TreeNode> stack = new Stack<>();
		LinkedList<Integer> res = new LinkedList<>();

		stack.push(root);
		while (!stack.empty()) {
			// 出栈顺序：中 -> 左 -> 右
			TreeNode node = stack.pop();
			res.addLast(node.val);
			// 前序遍历，所以要先压入右子节点，下一次弹出则会先弹出左子节点
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return res;
	}
}
