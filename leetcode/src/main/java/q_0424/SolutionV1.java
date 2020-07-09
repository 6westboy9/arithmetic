package q_0424;

import java.util.Arrays;

/**
 * @author pengbo.wang
 * @date 2020/07/08 10:21 下午
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        String s = "BAAACAB";
        int k = 2;
        System.out.println(solution.characterReplacement(s, k));
    }

    // 左边界不动，右边界先前进（扩大窗口），什么时候停止呢？窗口内非重复元素个数小于 k 时，停止
    // 右边界停止后，前进左边界（缩小窗口），什么时候停止呢？窗口内非重复元素个数等于 k 时，停止


    // 重复元素的定义


    // 问题：怎么统计非重复元素和重复元素，字面理解为，当前窗口大小内，相同元素占比多的为重复元素，否则为非重复元素，比如一开始 ABABC，k=1，记 length = 替换后的最长重复字符
    //
    // 开始遍历 A 只有一个 A 时，左右边界都是 A，可以认为 A 既是重复元素也是非重复元素，非重复元素 A 数量 <= k，所以右边界继续前进（length = 1）
    // AB 时，此时非重复元素个数为 1 <= k，所以右边界继续前进（length = 2）
    // ABA 时，此时 A 为重复元素，个数为 2，B 为非重复元素个数为 1，B 的数量 <= k，所以右边界继续前进（length = 3）
    // ABAB 时，区分不来谁是重复和非重复，A 和 B 都是两个，且 > k，所以改为左边界前进（length = 3）
    // BAB 时，此时非重复元素个数为 1 <= k，所以右边界继续前进（length = 3）
    // BABC 时，此时非重复元素个数为 3 > k，改为左边界前进（length = 3），C 已经是右边界，当窗口大小 <= length 结束
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;               // 表示窗口左边界
        int[] counts = new int[26]; // 用来统计窗口内每个元素个数

        int maxCount = 0;
        int maxCountIndex = -1;

        int allCount = 0;           // 用来统计窗口内所有元素总和
        int res = 0;                // 替换后的最长重复字符大小

        // right 表示窗口右边界
        for (int right = 0; right < chars.length; right++) {
            int count = ++counts[chars[right] - 'A'];

            if (count > maxCount) {
                maxCountIndex = right;
                maxCount = count;
            }

            ++allCount;

            // allCount - maxCount 非重复元素
            if (allCount - maxCount > k) {
                int index = chars[left] - 'A';
                counts[index]--; // 左边界迁移前需要将窗口该边界元素个数减一

                if (index == maxCountIndex) {
                    maxCount--;
                }

                allCount--; // 相应的窗口内总数也需要减一
                left++; // 左边界迁移
            }
            res = Math.max(allCount, res);
        }
        return res;
    }

}
