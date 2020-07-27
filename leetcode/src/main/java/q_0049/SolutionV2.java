package q_0049;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author pengbo.wang
 * @date 2020/07/27 8:25 下午
 */
public class SolutionV2 {

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        String[] strs = {"bur", "rub", "eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = solution.groupAnagrams(strs);
        System.out.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            int[] ints = new int[26];
            for (char ch : str.toCharArray()) {
                ints[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : ints) {
                sb.append(i);
            }

            String key = sb.toString();


            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
