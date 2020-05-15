package q_0238;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV2 {

	public static void main(String[] args) {
		SolutionV2 solution = new SolutionV2();
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
	}

	/**
	 * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			left[i] = i == 0 ? 1 : nums[i - 1] * left[i - 1];
		}

		int[] right = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			right[i] = i == nums.length - 1 ? 1 : nums[i + 1] * right[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = left[i] * right[i];
		}
		return nums;
	}
}
