package q_0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四数之和
 *
 * @author pengbo
 * @since 2021/2/21
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        // int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0,0,0,0};
        int target = 0;
        List<List<Integer>> res = solution.fourSum(nums, target);
        res.forEach(System.out::println);
    }

    /**
     * 易理解（思想同三数之和）
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return res;
        }

        // -2, -1, 0, 0, 1, 2
        Arrays.sort(nums);

        // System.out.println(Arrays.toString(nums));
        // System.out.println("iStart=0, iEnd=" + (nums.length - 4));
        // System.out.println("jStart=1, jEnd=" + (nums.length - 3));
        // System.out.println("kStart=2, kEnd=" + (nums.length - 2));
        // System.out.println("lStart=3, lEnd=" + (nums.length - 1));


        // 第一层循环
        for (int i = 0; i <= len - 4; i++) {
            // 当的值与前面的值相等时忽略
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min1 = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min1 > target) {
                break;
            }

            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏
            int max1 = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (max1 < target) {
                continue;
            }

            // 第二层循环
            for (int j = i + 1; j <= len - 3; j++) {
                // 当的值与前面的值相等时忽略
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = len - 1;

                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
                int min2 = nums[i] + nums[j] + nums[start] + nums[start + 1];
                if (min2 > target) {
                    break;
                }

                // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏
                int max2 = nums[i] + nums[j] + nums[end] + nums[end - 1];
                if (max2 < target) {
                    continue;
                }

                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        end--;

                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return res;
    }
}
