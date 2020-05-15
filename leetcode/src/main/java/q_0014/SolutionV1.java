package q_0014;

/**
 * 最长公共前缀
 *
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		// fl
		// String[] strs = {"flower", "flow", "flight"};
		// String[] strs = {"", "flow"};
		String[] strs = {"aaa", "aa", "aaa"};
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.longestCommonPrefix(strs));

		// System.out.println("flower".indexOf("flow"));

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;

			// 注意重要条件 j < res.length()，可以防止以下两种情况出现异常
			// String[] strs = {"", "flow"};
			// String[] strs = {"aaa", "aa", "aaa"};
			for (; j < res.length() && j < strs[i].length(); j++) {
				if ((res.charAt(j) != strs[i].charAt(j))) {
					break;
				}
			}

			res = res.substring(0, j);
			if ("".equals(res)) {
				return res;
			}
		}

		return res;
	}

}
