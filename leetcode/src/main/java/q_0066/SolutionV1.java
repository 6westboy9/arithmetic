package q_0066;

import java.util.Arrays;

/**
 * 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author pengbo
 * @since 2021/2/24
 */
public class SolutionV1 {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        // {1, 0, 0, 0}
        // int[] digits = {1, 2, 3};
        // int[] digits = {4, 3, 2, 9};
        SolutionV1 solution = new SolutionV1();
        int[] res = solution.plusOne(digits);
        System.out.println(Arrays.toString(res));
    }

    // 输入：digits = [1,2,3]
    // 输出：[1,2,4]
    // 解释：输入数组表示数字 123。
    //
    // 输入：digits = [4,3,2,1]
    // 输出：[4,3,2,2]
    // 解释：输入数组表示数字 4321。
    //
    // 输入：digits = [0]
    // 输出：[1]
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                flag = true;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }

        if (flag && i == -1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            digits = res;
        }
        return digits;
    }

}
