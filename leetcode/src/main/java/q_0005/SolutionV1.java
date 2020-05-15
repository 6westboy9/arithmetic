package q_0005;

/**
 * @author westboy
 * @since 2020/2/12
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.longestPalindrome("a"));
		// System.out.println(solution.isPalindromic("abba"));
		// System.out.println(solution.isPalindromic("aba"));
	}

	/**
	 * 暴力解法
	 */
	public String longestPalindrome(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			// 注意此处 j 的范围为 <= s.length()，因为 substring 截取的字符串是前闭后开
			for (int j = i + 1; j <= s.length(); j++) {
				String test = s.substring(i, j);
				if (isPalindromic(test) && test.length() >= res.length()) {
					res = test;
				}
			}
		}

		return res;
	}

	/**
	 * 判断是否是回文数
	 */
	private boolean isPalindromic(String test) {
		int len = test.length();
		int mid = len / 2;

		for (int i = 0; i < mid; i++) {
			if (test.charAt(i) != test.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
