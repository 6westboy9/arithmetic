package q_1160;

import java.util.HashMap;
import java.util.Map;

/**
 * @author westboy
 * @since 2020/3/17
 */
public class SolutionV1 {
	public static void main(String[] args) {
		String[] words = {"hello","world","leetcode"};
		String chars = "welldonehoneyr";

		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.countCharacters(words, chars));

	}


	public int countCharacters(String[] words, String chars) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (char c : chars.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}

		int len = 0;
		for (String word : words) {
			Map<Character, Integer> wordCharMap = new HashMap<>();
			for (char c : word.toCharArray()) {
				wordCharMap.put(c, wordCharMap.getOrDefault(c, 0) + 1);
			}

			boolean flag = false;
			for (Map.Entry<Character, Integer> entry : wordCharMap.entrySet()) {
				if (!charMap.containsKey(entry.getKey()) || charMap.get(entry.getKey()).compareTo(entry.getValue()) < 0 ) {
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			}

			len += word.length();
		}

		System.out.println(charMap);

		return len;
	}
}
