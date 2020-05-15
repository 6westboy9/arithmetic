package q_0056;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>要求：时间复杂度是 O(n)，空间复杂度是 O(1)。
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }

    // 异或操作的性质：对于两个操作数的每一位，相同结果为 0，不同结果为 1。
    // 在只有一个出现一次的数组中全员进行异或操作。那么在计算过程中，成对出现的数字的所有位会两两抵消为 0，最终得到的结果就是那个出现了一次的数字。

    // 那么如何找出两个出现一次的数字呢？把所有数字分成两组，使得这两组满足以下两个条件：
    // 1. 两个只出现一次的数字在不同的组中；
    // 2. 相同的数字在同一组中。
    // 那么对这两个数组分别进行异或操作，即可得到答案的两个数字，所以最重要的是如何分组？

    // 遗留：头皮发麻，搞不动了


    public int[] singleNumbers(int[] nums) {
        // 记录全员异或操作结果
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        // 对于 [4, 2, 4, 6] 最终异或结果为 2 和 6 的异或结果
        // 010 2
        // 110 6
        // 100
        System.out.println(Integer.toBinaryString(ret));

        // 001
        // 100
        // 010
        // int div = 1;
        // while ((div & ret) == 0) {
        //     div <<= 1;
        // }
        // System.out.println(div);
        return null;
    }

}
