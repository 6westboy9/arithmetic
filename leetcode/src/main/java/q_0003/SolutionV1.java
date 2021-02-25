package q_0003;

import java.util.HashMap;

/**
 * @author westboy
 * @since 2020/1/10
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
	}

	/**
	 * 借助滑动窗口思想
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}

		// map 存储的是字符与其索引的映射
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;

		// 滑动窗口左边界
		int left = 0;

		for (int i = 0; i < s.length(); i++) {
			// 如果存在重复字符，则左移至 max(left，重复字符出现的下标)
			if (map.containsKey(s.charAt(i))) {
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}

			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
}
