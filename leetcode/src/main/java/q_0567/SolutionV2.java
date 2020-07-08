package q_0567;

import java.util.Arrays;

/**
 * 自己参照 SolutionV1 也就是他人的答案思路实现方案
 *
 * @author pengbo.wang
 * @date 2020/07/07 8:07 上午
 */
public class SolutionV2 {

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        // String s1 = "ab";
        // String s2 = "eidbaooo";
        // String s1 = "adc";
        // String s2 = "dcda";
        String s1 = "ab";
        String s2 = "ab";
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
     */
    public boolean checkInclusion(String s1, String s2) {
        // 使用数组下标表示相应字符，chars1[char1 - 'a'] 表示相应字符的数量
        int[] ch1 = new int[26];
        for (char ch : s1.toCharArray()) {
            ch1[ch - 'a']++;
        }

        int[] ch2 = new int[26];
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            // s1=ab
            // s2=eidbaooo
            // i从0开始遍历，当i<ch1.length时，只做字符统计
            // 当 i >= ch1.length 时，要加以判断两个数组时否相等（即判断两个数字相同字符数量是否相等），如果相等则返回true，如果不相等，则需要将窗口左边界右移一位，相应的迁移之前左边界对应字符的统计需要减一，且右移一位后需要将其统计到窗口大小内
            if (i < s1.length()) {
                ch2[chars2[i] - 'a']++;
                // 遍历至最后一个字符元素时，需要加判断，否则退出循环将不会进行判断
                if (i == chars2.length - 1 && Arrays.equals(ch1, ch2)) {
                    return true;
                }
            } else {
                if (Arrays.equals(ch1, ch2)) {
                    return true;
                } else {
                    // i - ch1.length 定位到右移前的左边界
                    // ch2[chars2[i - s1.length()] - 'a'] 定位到右移前的左边界的字符
                    // ch2[chars2[i - s1.length()] - 'a']-- 将定位到的右移前的左边界的字符统计减一
                    ch2[chars2[i - s1.length()] - 'a']--;
                    // 且右移一位后需要将其统计到窗口大小内
                    ch2[chars2[i] - 'a']++;

                    // 遍历至最后一个字符元素时，需要加判断，否则退出循环将不会进行判断
                    if (i == chars2.length - 1 && Arrays.equals(ch1, ch2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
