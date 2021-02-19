package q_0034;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * @author westboy
 * @since 2020/1/9
 */
public class SolutionV1 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 3, 4};
        SolutionV1 v1 = new SolutionV1();
        System.out.println(Arrays.toString(v1.searchRange(nums, 1)));
    }

    /**
     * 思想
     * ① 先借助二分查找找到目标元素
     * ② 向左遍历查找相同目标元素的左边界
     * ③ 向右遍历查找相同目标元素的右边界
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                int left = mid; // 临时记录往左边界
                int right = mid; // 临时记录往右边界
                range[0] = left;
                range[1] = right;

                // 向左遍历查找相同目标元素的左边界
                // m > low 当 m = low 时，--m 就会发生越界
                while (left > low && nums[--left] == target) {    // 查找最左边界
                    range[0] = left;
                }

                // 向右遍历查找相同目标元素的右边界
                // n < high 当 n = high 时，++n 就会发生越界
                while (right < high && nums[++right] == target) { // 查找最右边界
                    range[1] = right;
                }
                return range;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return range;
    }
}
