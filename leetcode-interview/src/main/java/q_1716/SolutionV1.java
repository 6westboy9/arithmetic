package q_1716;

/**
 * @author westboy
 * @since 2020/3/24
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		// int[] nums = {2,1,4,5,3,1,1,3};
		int[] nums = {1, 1};
		System.out.println(solution.massage(nums));
	}

	public int massage(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}

		int dp0 = 0;
		int dp1 = nums[0];

		// 注意：i 从 1 起始遍历
		for (int i = 1; i < nums.length; i++) {
			int dpt0 = Math.max(dp0, dp1);
			int dpt1 = dp0 + nums[i];

			dp0 = dpt0;
			dp1 = dpt1;
		}
		return Math.max(dp0, dp1);
	}
}
