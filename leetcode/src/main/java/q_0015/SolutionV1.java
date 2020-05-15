package q_0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = solution.threeSum(nums);
		res.forEach(System.out::println);
	}


	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		int len = nums.length;
		if (len < 3) {
			return ans;
		}

		// 排序
		Arrays.sort(nums);

		// 图解参考：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn
		for (int i = 0; i < len; i++) {
			// 如果当前数字大于 0，则三数之和一定大于 0，所以结束循环
			if (nums[i] > 0) {
				break;
			}
			// 去重
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// 去重
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					// 去重
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return ans;
	}
}
