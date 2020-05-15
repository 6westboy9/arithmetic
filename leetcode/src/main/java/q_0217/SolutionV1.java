package q_0217;

import java.util.HashSet;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] nums = {1, 2, 3, 4};
		// int[] nums = {1, 2, 3, 4, 1};
		System.out.println(solution.containsDuplicate(nums));
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}
}
