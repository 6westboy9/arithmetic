package q_0053;

/**
 * 最大子序和
 *
 * @author westboy
 * @since 2020/2/10
 */
public class SolutionV1 {
	public static void main(String[] args) {

		// 输入: [-2,1,-3,4,-1,2,1,-5,4]
		// 输出: 6
		// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6

		int[] arrs = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.maxSubArray(arrs));
	}

	// 贪心算法
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}

			ans = Math.max(ans, sum);
			System.out.println("sum:" + sum + ", ans=" + ans);
		}
		return ans;
	}
}
