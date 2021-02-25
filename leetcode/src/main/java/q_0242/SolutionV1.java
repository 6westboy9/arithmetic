package q_0242;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 *
 * @author pengbo.wang
 * @date 2020/07/27 7:44 下午
 */
public class SolutionV1 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.isAnagramV2(s, t));
    }

    // 除了使用 HashMap 之外可以使用数组来保存
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        for (char ch1 : s.toCharArray()) {
            map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch2 : t.toCharArray()) {
            map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
        }

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer cnt = map2.get(entry.getKey());
            if (cnt == null || !cnt.equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路同上，但是更优
     */
    public boolean isAnagramV2(String s, String t) {
        byte[] res = new byte[26];
        for (char ch1 : s.toCharArray()) {
            res[ch1 - 'a']++;
        }

        for (char ch2 : t.toCharArray()) {
            res[ch2 - 'a']--;
        }

        for (int i : res) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }


}
