package q_0238;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 *
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {1, 2, 3, 4};

        // 输入: [1,2,3,4]
		// 输出: [24,12,8,6]
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

    /**
     * 暴力解法
     */
    public int[] productExceptSelf(int[] nums) {
        int[] rNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int res = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    res *= nums[j];
                }
            }
            rNums[i] = res;
        }
        return rNums;
    }
}
