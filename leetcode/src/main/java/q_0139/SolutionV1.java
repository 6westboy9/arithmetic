package q_0139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 单词拆分
 *
 * @author pengbo.wang
 * @date 2020/07/11 2:19 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();

        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(solution.wordBreak(s, wordDict));


        // String s = "leetcode";
        // List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        // wordDict.add("code");
        // System.out.println(solution.wordBreak(s, wordDict));
    }

    /**
     * 暴力解法
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        //  012 3 456
        //  aaa a aa a
        // |   | |  | |
        // 0   3 4  6 7
        // dp[0]=true
        // dp[4]=true
        // dp[7]=true
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                String s1 = s.substring(j, i);
                if (wordDict.contains(s1) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
