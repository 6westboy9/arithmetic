package q_0567;

import java.util.Arrays;

/**
 *
 * 题目描述：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列
 *
 * -------------------------------------
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * -------------------------------------
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * -------------------------------------
 *
 * @author pengbo.wang
 * @date 2020/07/06 10:19 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2));
    }

    /**
     * 思路：滑动窗口思想
     *
     * 给定字符串 s1="ab" s2="eidbaooo"，因为 s2 包含 s1 的排列之一 ("ba") 所以返回 true
     *
     * 所以其实第一步思路可以转化为：固定 s2 的窗口大小为 s1 的长度，依次滑动窗口，只要窗口内相同字符的数量相等，即可认为 s2 包含 s1
     *
     * 怎么理解了呢？举个例子，就拿上面的示例进行说明，s2="eidbaooo"，s1="ab"，按照上面的思路，就是在 s2 中从头遍历，固定窗口大小为 2（即 s1 的长度），如果窗口内的相同字符的数量相同，就认为 s2 包含 s1
     *
     * [e,i] 与 [a,b] 向前推进 s2
     * [i,d] 与 [a,b] 向前推进 s2
     * [d,b] 与 [a,b] 向前推进 s2
     * [b,a] 与 [a,b] 相同字符数量相等，满足条件退出
     *
     */
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();


        int[] c1 = new int[26];
        int[] c2 = new int[26];

        // 统计每个字母元素的数量
        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }

        // 遍历 s2
        for (int i = 0; i < l2; i++) {
            // 先执行右移一位，并且对右移前的左边界进行减一
            if (i >= l1) {
                --c2[s2.charAt(i - l1) - 'a']; // i - l1
            }
            // 将新的右边界计入滑动窗口
            c2[s2.charAt(i) - 'a']++;
            // 判断数组是否相等，相等则意味着相同字符在滑动窗口内出现次数一样，则返回 true，否则返回 false
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;
    }


}
