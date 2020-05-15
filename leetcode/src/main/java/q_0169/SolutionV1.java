package q_0169;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author westboy
 * @since 2020/3/16
 */
public class SolutionV1 {
	public static void main(String[] args) {
		int[] nums = {2, 2, 1, 1, 1, 2, 2};

		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.majorityElement(nums));
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		System.out.println(map);

		int res = nums[0];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() >  (nums.length / 2)) {
				// System.out.println(entry.getKey() + " " + entry.getValue());
				res = entry.getKey();
			}
		}
		return res;
	}
}
