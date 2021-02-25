package q_0035;

/**
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(solution.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int i = 0;
        for (; i < len; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return i;
    }
}
