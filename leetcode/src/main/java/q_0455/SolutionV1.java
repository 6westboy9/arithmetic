package q_0455;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/2/11
 */
public class SolutionV1 {
	public static void main(String[] args) {
		// 孩子的胃口
		// int[] g = {1, 2, 3};
		int[] g = {1, 2};
		// 饼
		// int[] s = {1, 1};
		int[] s = {1, 2, 3};
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.findContentChildren(g, s));
	}

	public int findContentChildren(int[] g, int[] s) {
		if (g == null || g.length == 0) {
			return 0;
		}
		if (s == null || s.length == 0) {
			return 0;
		}

		Arrays.sort(g);
		Arrays.sort(s);

		int i = 0;
		int j = 0;
		while (i <= g.length - 1 && j <= s.length - 1) {
			if (s[j] >= g[i]) {
				i++;
			}
			j++;
		}
		return i;
	}
}
