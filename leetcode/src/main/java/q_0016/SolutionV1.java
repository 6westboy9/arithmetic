package q_0016;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] nums = {-1, 2, 1, -4};
		System.out.println(solution.threeSumClosest(nums, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		// 1. 先排序
		Arrays.sort(nums);
		// 2. 取一个三数之和的默认值
		int ans = nums[0] + nums[1] + nums[2];

		// 三数之和，i 为中间移动指针，最大有效指针为 nums.length - 2
		for (int i = 0; i < nums.length - 1; i++) {
			// 左边界
			int left = i + 1;
			// 右边界
			int right = nums.length - 1;

			while (left < right) {

				int sum = nums[i] + nums[left] + nums[right];
				if (abs(target, sum) < abs(target, ans)) {
					ans = sum;
				}

				// 三数之和小于目标值右移左边界
				if (sum < target) {
					left++;
				}
				// 三数之和大于目标值左移右边界
				else if (sum > target) {
					right--;
				} else {
					return sum;
				}
			}
		}
		return ans;
	}

	private int abs(int a, int b) {
		return Math.abs(a - b);
	}
}
