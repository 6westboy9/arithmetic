package q_0557;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.reverseWords("Let's take LeetCode contest"));
		// System.out.println(solution.reverse("abc"));
	}

	public String reverseWords(String s) {
		String[] strs = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (String str : strs) {
			res.append(reverse(str)).append(" ");
		}
		return res.substring(0, res.length() - 1);
	}

	public String reverse(String s) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length / 2; i++) {
			swap(chars, i, chars.length - i - 1);
		}
		return String.valueOf(chars);
	}

	private void swap(char[] chars, int i, int j) {
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}
}
