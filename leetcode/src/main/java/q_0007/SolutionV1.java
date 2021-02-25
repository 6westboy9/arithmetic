package q_0007;

import java.util.Arrays;

/**
 * 整数反转
 *
 * @author pengbo
 * @since 2021/2/20
 */
public class SolutionV1 {


    /**
     * 输入：x = 123
     * 输出：321
     *
     * 输入：x = -123
     * 输出：-321
     *
     * 输入：x = 120
     * 输出：21
     *
     * 输入：x = 0
     * 输出：0
     */
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-321));
        // System.out.println(solution.reverse(120));
    }



    public int reverse(int x) {
        boolean negative = x < 0;
        int absX = Math.abs(x);

        int numsLen = 32;
        int[] nums = new int[numsLen];
        int numsIdx = 0;

        while (absX > 0) {
            nums[numsIdx++] = absX % 10;
            absX = absX / 10;
        }

        // 退出循环是 numsIdx - 1 为有效数据最大边界下标
        // System.out.println(numsIdx);
        // System.out.println(Arrays.toString(nums));

        long res = 0;
        for (int i = 0; i < numsIdx; i++) {
            res = res * 10 + nums[i] >= Integer.MAX_VALUE ? 0 : res * 10 + nums[i];
        }

        // System.out.println(res);

        return res == 0 ? 0 : (int) (negative ? -res : res);
    }
}
