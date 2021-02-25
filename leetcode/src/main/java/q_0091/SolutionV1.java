package q_0091;

/**
 * 解码方法
 *
 * @author pengbo
 * @since 2021/2/25
 */
public class SolutionV1 {

    private final char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    //                             1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // 123 (1|2|3) (12|3) (1|23)
        // 226 (2|2|6) (22|6) (2|26)

        System.out.println(solution.numDecodings("123"));

    }

    // 输入：s = "12"
    // 输出：2
    // 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
    //
    // 输入：s = "226"
    // 输出：3
    // 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
    //
    // 输入：s = "0"
    // 输出：0
    // 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
    //
    // 输入：s = "06"
    // 输出：0
    // 解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。

    // 1 <= s.length <= 100
    // s 只包含数字，并且可能包含前导零。

    // 226
    // 2|26

    /**
     * 参考题解：https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1, cur = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;

            // 特殊情况
            if (s.charAt(i) == '0') {
                cur = (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') ? pre : 0;
            }
            // 大多数情况
            else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }

}
