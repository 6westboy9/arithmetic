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
        int[] nums = {1, 0, 0, 3, 12};

        System.out.println(Arrays.toString(nums));

        SolutionV1 solution = new SolutionV1();
        solution.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int j = 0; // 记录要填入的非零元素位置，在遍历数组时，如果遇到非零元素就填入到 j 这个位置，j++ 向前移动
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
