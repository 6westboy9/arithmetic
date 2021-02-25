package q_0005;

/**
 * 最大回文子串
 *
 * @author westboy
 * @since 2020/2/12
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        // System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("abba"));
        // System.out.println(solution.longestPalindrome("aba"));
    }

    /**
     * 中心扩散法（推荐）
     *
     * 参考题解：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) { // 最后一个元素就没必要作为中心继续扩散了，因为它的右边没有元素
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;

                // 需要画图发现规律（在参考题解：4:48s 处有其推到公式）
                begin = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    /**
     * 查找以 left、right 为中心扩散的边界
     *
     * @param charArray 原始字符串的字符数组
     * @param left      起始中心左边界
     * @param right     起始中心右边界
     * @return 回文串的长度
     */
    private int expandAroundCenter(char[] charArray, int left, int right) {
        while ((left >= 0 && right <= charArray.length - 1)
                && charArray[left] == charArray[right]) {
            left--;
            right++;
        }

        // 跳出 while 循环时，恰好满足 charArray[left] != charArray[right]
        // 回文串的长度为 right 和 left 之间的元素的长度（不包括 left 和 right 指向的元素）
        // right - left + 1 - 2 = right - left - 1
        return right - left - 1;
    }

}
