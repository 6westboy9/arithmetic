package q_0424;

/**
 * @author pengbo.wang
 * @date 2020/07/09 4:07 下午
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        String s = "BAAACAB";
        int k = 2;
        System.out.println(solution.characterReplacementV1(s, k));
    }

    public int characterReplacementV1(String s, int k) {
        int left = 0, right = 0;
        int result = 0;
        int maxLen = -1; // 保存当前窗口范围内最多的字符的长度

        int[] charNums = new int[26];

        while (right < s.length()) {
            char cur = s.charAt(right);
            charNums[cur - 'A']++;
            maxLen = Math.max(maxLen, charNums[cur - 'A']);
            while ((right - left + 1 - maxLen) > k) {
                charNums[s.charAt(left++) - 'A']--;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
