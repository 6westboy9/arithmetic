package q_0283;

import java.util.Arrays;

/**
 * 移动零
 *
 * @author pengbo.wang
 * @date 2020/07/13 9:24 上午
 */
public class SolutionV2 {

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 3, 12};

        System.out.println(Arrays.toString(nums));

        SolutionV2 solution = new SolutionV2();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
