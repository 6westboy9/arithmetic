package q_0005;

/**
 * 最大回文子串
 *
 * @author westboy
 * @since 2020/2/12
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("abba"));
        // System.out.println(solution.longestPalindrome("aba"));
    }

    /**
     * 暴力解法
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {   // 注意 i 最大值为 len - 2
            for (int j = i + 1; j < len; j++) { // 注意 j 最大值为 len - 1
				// 先进行 j - i + 1 > maxLen 长度判断，不满足就不需要进行回文判断了
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否是回文数
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
