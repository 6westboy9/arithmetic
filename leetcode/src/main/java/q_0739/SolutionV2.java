package q_0739;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {

	public static void main(String[] args) {
		// 输出 1, 1, 4, 2, 1, 1, 0, 0
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
		SolutionV2 v2 = new SolutionV2();
		System.out.println(Arrays.toString(v2.dailyTemperatures(temperatures)));
	}

	/**
	 * 最优，贼屌，反向遍历跳着来！惊呆了！！！
	 *
	 * @param T 温度列表
	 * @return 结果
	 */
	public int[] dailyTemperatures(int[] T) {
		int length = T.length;
		int[] result = new int[length];

		//从右向左遍历
		for (int i = length - 2; i >= 0; i--) {
			// j+= result[j]是利用已经有的结果进行跳跃
			for (int j = i + 1; j < length; j += result[j]) {
				if (T[j] > T[i]) {
					result[i] = j - i;
					break;
				} else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
					result[i] = 0;
					break;
				}
			}
		}

		return result;
	}
}
