package q_0005;

/**
 * @author westboy
 * @since 2020/2/12
 */
public class SolutionV2 {
	public static void main(String[] args) {
		SolutionV2 solution = new SolutionV2();
		System.out.println(solution.longestPalindrome("abba"));
		// System.out.println(solution.expandAroundCenter("abba", 1, 2));
		System.out.println(3/2);
	}

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}

		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// 需要考虑两种情况：
			// 1.字符串长度为奇数时中心扩展
			int len1 = expandAroundCenter(s, i, i);
			// 2.字符串长度为偶数时中心扩展
			int len2 = expandAroundCenter(s, i, i + 1);

			// 求得最大回文子串长度
			int len = Math.max(len1, len2);
			// 定位最大回文子串起始位置
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
