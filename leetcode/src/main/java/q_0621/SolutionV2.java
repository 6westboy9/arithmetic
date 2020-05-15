package q_0621;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/2/11
 */
public class SolutionV2 {
	public static void main(String[] args) {
		SolutionV2 solution = new SolutionV2();
		char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
		System.out.println(solution.leastInterval(tasks, 2));
	}

	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks) {
			map[c - 'A']++;
		}

		Arrays.sort(map);
		int maxVal = map[25] - 1;
		int idleSlots = maxVal * n;

		for (int i = 24; i >= 0 && map[i] > 0; i--) {
			idleSlots -= Math.min(map[i], maxVal);
		}
		return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
	}
}
