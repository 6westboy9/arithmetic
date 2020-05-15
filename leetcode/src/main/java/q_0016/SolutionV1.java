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
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (abs(target, sum) < abs(target, ans)) {
					ans = sum;
				}

				if (sum < target) {
					left++;
				} else if (sum > target) {
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
