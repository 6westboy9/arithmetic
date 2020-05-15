package q_0344;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/2/21
 */
public class SolutionV1 {
	public static void main(String[] args) {
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		SolutionV1 solution = new SolutionV1();
		System.out.println(Arrays.toString(s));
		solution.reverseString(s);
		System.out.println(Arrays.toString(s));

		System.out.println(3/2);
		System.out.println(4/2);
	}

	public void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			swap(s, i, s.length - 1 - i);
		}
	}

	private void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}

}
