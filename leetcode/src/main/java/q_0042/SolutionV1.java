package q_0042;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(solution.trap(height));
	}

	/**
	 * 暴力解法：找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
	 */
	public int trap(int[] height) {
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			// 求得其左边最大高度
			int leftMaxHeight = 0;
			for (int j = 0; j <= i; j++) {
				if (height[j] > leftMaxHeight) {
					leftMaxHeight = height[j];
				}
			}

			int rightMaxHeight = 0;
			for (int k = height.length - 1; k >= i; k--) {
				if (height[k] > rightMaxHeight) {
					rightMaxHeight = height[k];
				}
			}

			res += Math.min(leftMaxHeight, rightMaxHeight) - height[i];
		}
		return res;
	}
}
