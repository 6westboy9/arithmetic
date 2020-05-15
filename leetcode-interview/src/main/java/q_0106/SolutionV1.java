package q_0106;

/**
 * @author westboy
 * @since 2020/3/16
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		String s = "aabcccccaaa";
		System.out.println(solution.compressString(s));
	}

	public String compressString(String S) {
		char[] chars = S.toCharArray();

		if (chars.length == 0 || chars.length == 1) {
			return chars.length == 1 ? String.valueOf(chars[0]) : "";
		}

		char preChar = chars[0];
		int preCnt = 1;
		StringBuilder s = new StringBuilder();
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == preChar) {
				preCnt++;
			} else {
				s.append(preChar).append(preCnt);
				preCnt = 1;
				preChar = chars[i];
			}
		}
		s.append(preChar).append(preCnt);

		return s.length() >= chars.length ? S : s.toString();
	}
}
