package q_0043;

import java.util.Arrays;

/**
 * 字符串相乘
 *
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.multiply("123", "45"));
	}

	// [0, 0, 0, 1, 5]
	// [0, 0, 1, 3, 5]
	// [0, 0, 2, 3, 5]
	// [0, 1, 0, 3, 5]
	// [0, 1, 5, 3, 5]
	// [0, 5, 5, 3, 5]
	public String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}

		int[] res = new int[num1.length() + num2.length()];

		for (int i = num1.length() - 1; i >= 0; i--) {
			int n1 = num1.charAt(i) - '0';
			for (int j = num2.length() - 1; j >= 0; j--) {
				int n2 = num2.charAt(j) - '0';

				int sum = res[i + j + 1] + n1 * n2;
				// 余数
				res[i + j + 1] = sum % 10;
				// 进位
				res[i + j] += sum / 10;

				System.out.println(Arrays.toString(res));
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			if (i == 0 && res[i] == 0) {
				continue;
			}
			result.append(res[i]);
		}
		return result.toString();
	}
}
