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

	public int maxArea(int[] height) {
		int maxarea = 0, left = 0, right = height.length - 1;
		while (left < right) {
			maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxarea;
	}
}
