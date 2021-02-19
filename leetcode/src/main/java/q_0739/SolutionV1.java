package q_0739;

import java.util.Arrays;

/**
 * 请根据每日气温列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * @author westboy
 * @since 2020/1/10
 */
public class SolutionV1 {
	public static void main(String[] args) {
		// 输出 1, 1, 4, 2, 1, 1, 0, 0
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
		SolutionV1 v1 = new SolutionV1();
		System.out.println(Arrays.toString(v1.dailyTemperatures(temperatures)));
	}

	/**
	 * 暴力解法（最差）
	 *
	 * @param T 温度列表
	 * @return 结果
	 */
	public int[] dailyTemperatures(int[] T) {
		int length = T.length;
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			int current = T[i];
			if (current < 100) {
				for (int j = i + 1; j < length; j++) {
					if (T[j] > current) {
						result[i] = j - i;
						break;
					}
				}
			}
		}
		return result;
	}
}
