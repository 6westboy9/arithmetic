package q_0049;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author pengbo.wang
 * @date 2020/07/27 8:01 下午
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String[] strs = {"bur", "rub", "eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String k = convert(str);
            List<String> strings = map.getOrDefault(k, new ArrayList<>());
            strings.add(str);
            map.put(k, strings);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String convert(String str) {
        Map<Character, Integer> map = new TreeMap<>(Character::compareTo);
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        return sb.toString();
    }
}
