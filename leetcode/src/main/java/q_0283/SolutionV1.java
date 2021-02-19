package q_0283;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author pengbo.wang
 * @date 2020/07/13 8:52 上午
 */
public class SolutionV1 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 0, 3, 12};

        System.out.println(Arrays.toString(nums));

        SolutionV1 solution = new SolutionV1();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 1 4 0 3 12           1 4 0 3 12
     * j                    j
     * i                    i
     *
     * 1 4 0 3 12           1 4 0 3 12
     *   j                    j
     *   i                    i
     *
     * 1 4 0 3 12           1 4 0 3 12
     *     j                    j
     *     i                    i
     *
     * 1 4 0 3 12           1 4 3 0 12
     *     j                      j
     *       i                    i
     *
     * 1 4 3 0 12           1 4 3 12 0
     *       j                       j
     *         i                     i
     *
     * 可以将 j 理解为一个边界，左边（不包含 j）都是相对顺序的非 0 元素
     * 右边（包含 j）都是 0 元素
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
