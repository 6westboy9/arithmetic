package q_0238;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
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
     * 乘积 = 当前数左边的乘积 * 当前数右边的乘积（推荐，易理解）
     * <p>
     * 每个元素左边乘积 1,  1,  2, 6
     * <p>
     * 每个元素右边乘积 24, 12, 4, 1
     */
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
		int[] right = new int[nums.length];


        // 从头到尾遍历
        for (int i = 0; i < nums.length; i++) {
            left[i] = i == 0 ? 1 : nums[i - 1] * left[i - 1];
        }

		// 从尾到头遍历
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = i == nums.length - 1 ? 1 : nums[i + 1] * right[i + 1];
        }


        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
