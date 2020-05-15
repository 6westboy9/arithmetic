package q_0238;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV3 {

	public static void main(String[] args) {
		SolutionV3 solution = new SolutionV3();
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
	}

	/**
	 * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = i == 0 ? 1 : nums[i - 1] * res[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * right;
			right *= nums[i];
		}
		return res;
	}
}
