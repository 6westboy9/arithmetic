package q_0621;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/2/11
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		System.out.println(solution.leastInterval(tasks, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks) {
			map[c - 'A']++;
		}
		Arrays.sort(map);
		int time = 0;
		while (map[25] > 0) {
			int i = 0;
			while (i <= n) {
				if (map[25] == 0) {
					break;
				}
				if (i < 26 && map[25 - i] > 0) {
					map[25 - i]--;
				}
				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}
}
