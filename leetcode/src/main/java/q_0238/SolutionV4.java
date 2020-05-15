package q_0238;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV4 {

	public static void main(String[] args) {
		SolutionV4 solution = new SolutionV4();
		int[] nums = {1, 2, 3, 4};
		System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
	}

	/**
	 * 乘积 = 当前数左边的乘积 * 当前数右边的乘积
	 */
	public int[] productExceptSelf(int[] nums) {
		int left = 1;
		int right = 1;
		int[] res = new int[nums.length];

		Arrays.fill(res, 1);

		for (int i = 0; i < nums.length; i++) {
			// 计算出不包含当前数的左边的乘积
			res[i] *= left;
			left *= nums[i];

			// System.out.print(Arrays.toString(res));

			res[nums.length - 1 - i] *= right;
			right *= nums[nums.length - 1 - i];

			// System.out.println(Arrays.toString(res));
		}
		return res;
	}
}
