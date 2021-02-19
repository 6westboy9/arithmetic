package q_0075;

import cn.hutool.json.JSONUtil;

import java.util.Arrays;

/**
 * 颜色分类
 *
 * @author pengbo
 * @since 2020/11/18
 */
public class SolutionV1 {

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        SolutionV1 solution = new SolutionV1();
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    public void sortColors(int[] nums) {
        int less = -1;          // 开始的时候还没有元素，左边界从 -1 开始
        int more = nums.length; // 开始的时候还没有元素，右边界从 nums.length 开始
        int current = 0;
        int target = 1;
        while (current < more) {
            System.out.print(JSONUtil.toJsonStr(nums));
            System.out.print(" less: " + less + ", more: " + more + ", current: " +current);

            // 注意点
            // 小于等于 target 时，current 需要右移
            // 大于 target 时，current 不需要右移

            String msg;
            if (nums[current] < target) {
                msg = "小于目标元素, less 右移, 交换 current 与 less 元素, current 右移";
                swap(nums, current++, ++less);
            } else if (nums[current] > target) {
                msg = "大于目标元素, more 左移, 交换 current 与 more 元素, current 不动";
                swap(nums, current, --more);
            } else {
                msg = "等于目标元素, current 右移";
                current++;
            }
            System.out.println("\t-----------> " + msg);
            System.out.print(JSONUtil.toJsonStr(nums));
            System.out.println(" less: " + less + ", more: " + more + ", current: " +current);
            System.out.println();
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
