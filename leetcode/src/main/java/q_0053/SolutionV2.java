package q_0053;

/**
 * 最大子序和
 *
 * @author westboy
 * @since 2020/2/10
 */
public class SolutionV2 {
	public static void main(String[] args) {

		// 输入: [-2,1,-3,4,-1,2,1,-5,4]
		// 输出: 6
		// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6

		int[] arrs = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		SolutionV2 solution = new SolutionV2();
		System.out.println(solution.maxSubArray(arrs));
	}

	// 动态规划（易理解版）
	// 状态转移方程式：dp[i] = max(dp[i-1] + nums[i], nums[i])，dp[i] 表示索引 i 为结束点基准的子数组的最大值
	// 初始状态：dp[0] = nums[0]
	public int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int curSum = 0;
		for (int num : nums) {

			curSum = Math.max(curSum + num, num); // ①

			// 上述的 ① 演化版本
			// curSum + num 和 num 自己比较大小，只有 curSum 小于等于 0 时，curSum = num
			// 所以，上述的 ① 可以改写为 curSum = curSum > 0 ? curSum + num : num;
			// 等同于 curSum = curSum > 0 ? curSum + num : num;

			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}
}
