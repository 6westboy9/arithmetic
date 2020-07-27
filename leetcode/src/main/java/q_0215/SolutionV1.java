package q_0215;

import java.util.Random;

/**
 * 数组中第 K 个最大元素
 *
 * @author westboy
 * @since 2020/3/16
 */
public class SolutionV1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 6, 1, 4, 2};
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.findKthLargest(nums, 2));

    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, len - k);
    }

    /**
     * @param kSmallest 第 k 大元素之前元素个数
     */
    public int quickSelect(int[] nums, int left, int right, int kSmallest) {
        // System.out.println(Arrays.toString(nums) + ", left=" + left + ", right=" + right);


        // [1, 2, 5, 6, 3, 4, 2], pivot=2, [1] [2, 5, 6, 3, 4, 2], storeIndex=1, left=0, right=6
        // [1, 2, 2, 3, 5, 4, 6], pivot=3, [1, 2, 2] [3, 5, 4, 6], storeIndex=3, left=storeIndex+1=2, right=6
        // [1, 2, 2, 3, 4, 6, 5], pivot=4, [1, 2, 2, 3] [4, 6, 5], storeIndex=4, left=storeIndex+1=2, right=6
        // [1, 2, 2, 3, 4, 5, 6], pivot=6, [1, 2, 2, 3, 4, 5] [6], storeIndex=6, left=storeIndex+1=5, right=6
        // 5                                                                     left=5, right=storeIndex-1=5

        // 重点：需要考虑的边界问题，递归只有一个元素时，为什么只剩一个元素时就是所求答案呢？
        if (left == right) {
            return nums[left];
        }

        // 分区返回的是基准左侧数组长度，此时 num[pivotIndex] 为基准元素值
        int pivotIndex = partition(nums, left, right);
        // 分区返回的是基准左侧数组长度 = 第 k 大元素之前元素个数，所以第 k 大元素就等于 num[pivotIndex]
        if (kSmallest == pivotIndex) {
            return nums[pivotIndex];
        }
        // 分区返回的是基准左侧数组长度 > 第 k 大元素之前元素个数
        else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        }
        // 分区返回的是基准左侧数组长度 < 第 k 大元素之前元素个数
        else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    /**
     * 分区
     *
     * @param nums  目标数组
     * @param left  目标数组左边界
     * @param right 目标数组右边界
     * @return 基准左侧数组长度
     */
    private int partition(int[] nums, int left, int right) {
        // 随机基准元素下标
        int pivotIndex = left + new Random().nextInt(right - left);
        // 基准元素
        int pivot = nums[pivotIndex];
        // 用于存储根据基准元素分区之后，基准元素所在数组中的下标位置
        int storeIndex = left;

        // 将基准元素交换至最右侧
        swap(nums, pivotIndex, right);

        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIndex++);
            }
        }

        // 最后将基准元素交换至合适位置
        swap(nums, storeIndex, right);

        // int[] leftNums = new int[storeIndex];
        // int[] rightNums = new int[nums.length - storeIndex];
        // System.arraycopy(nums, 0, leftNums, 0, storeIndex);
        // System.arraycopy(nums, storeIndex, rightNums, 0, nums.length - storeIndex);
        // System.out.println(Arrays.toString(nums) + ", pivot=" + pivot + ", " + Arrays.toString(leftNums) + " " + Arrays.toString(rightNums) + ", storeIndex=" + storeIndex);

        // 最终返回基准元素的位置
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
