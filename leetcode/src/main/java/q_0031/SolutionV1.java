package q_0031;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author pengbo
 * @since 2021/2/22
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {2, 4, 5, 3, 4, 4, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 题解来源：https://www.bilibili.com/video/BV1SK4y1V7ch?from=search&seid=13759201055600557106
     *
     * 2, 4, 5, 3, 4, 4, 2, 1
     * 2, 4, 5, 4, 1, 2, 3, 4
     *          |
     *      之前都是单调递增，4 是 3 后面大于 3 的最小数
     *
     * 如果都是单调递减的，只需要反过来即可，比如 4, 3, 2, 1 反过来结果：1, 2, 3, 4
     *
     * 1. 我们想要最小的解，所以尽可能去动位数最小的数字
     * 2. 单调递减是没有解的，所以第一个不是单调递增的位置就存在解
     * 3. 把解的位置换成后半部分比自己大的最小数字来构成最优解
     * 4. 交换之后要保证后半部分尽可能小（单调递增）
     *
     * 具体思路
     * 1. 从后往前找到第一个破坏单调递增性质的位置（x, y）
     * 2. 将 array[x] 与 array[y, n) 中比 array[x] 大的最小的数字交换（注意是靠后的）
     * 3. 将 array[y, n) 反过来
     * 4. 别忘了特殊处理整个 array 本身就是单调递减的情况
     */
    public void nextPermutation(int[] nums) {
        //
        int len = nums.length;
        if (len == 1) {
            return;
        }

        int idx = len - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }

        // 整个数组成递减，直接翻转即可
        if (idx < 0) {
            reverse(nums, 0, len - 1);
            return;
        }

        int larger = idx + 1; // 第一个不满足递增性质的位置（示例中的 3，此时 idx 已经指向了 3，从 3 后面的元素（idx+1）往后查找大于 3 的最小元素）
        // 3 之后的元素成递减性质，一直遍历找到满足大于 3 的最后一个元素，即就是大于 3 的最小元素
        while (larger < len && nums[larger] > nums[idx]) {
            larger++;
        }

        // 上述 while 不满大于 3 时跳出循环，跳出时，larger 指向 2，所以大于 3 的最小元素的下标为 larger - 1，指向 4
        // 交换元素
        swap(nums, idx, larger - 1);
        // 交换后也是递减性质，只需要进行翻转后续元素即可
        reverse(nums, idx + 1, len -1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
