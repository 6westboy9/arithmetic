package q_0136;

/**
 * @author pengbo.wang
 * @date 2020/07/09 4:44 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 3};
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
