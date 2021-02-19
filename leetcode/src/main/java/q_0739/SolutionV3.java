package q_0739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV3 {

	public static void main(String[] args) {
		// 输出 1, 1, 4, 2, 1, 1, 0, 0
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
		SolutionV3 v3 = new SolutionV3();
		System.out.println(Arrays.toString(v3.dailyTemperatures(temperatures)));
	}

	/**
	 * 使用栈（较差）
	 *
	 * @param T 温度列表
	 * @return 结果
	 */
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] days = new int[T.length];
		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && (T[i] >= T[stack.peek()])) {
				stack.pop();
			}
			days[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return days;
	}

}
