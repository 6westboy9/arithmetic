package q_0011;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(solution.maxArea(height));
	}

	/**
	 * 双边移动，谁小先移动谁
	 */
	public int maxArea(int[] height) {
		int maxArea = 0, left = 0, right = height.length - 1;
		int minLength, area;
		while (left < right) {
			// 更优雅的写法
			// 指针移动规则：左边界高度小于右边界高度，右移左边界，否则，左移右边界
			// 指针移动规则证明：https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
			minLength = height[left] < height[right] ? height[left++] : height[right--];
			area = (right - left) * minLength;
			maxArea = Math.max(maxArea,  area);

			// maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			//
			// if (height[left] < height[right]) {
			// 	left++;
			// } else {
			// 	right--;
			// }
		}
		return maxArea;
	}
}
