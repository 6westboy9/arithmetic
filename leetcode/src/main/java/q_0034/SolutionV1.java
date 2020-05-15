package q_0034;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/1/9
 */
public class SolutionV1 {
	public static void main(String[] args) {
		int[] nums = {1, 3, 3, 3, 3, 4};
		SolutionV1 v1 = new SolutionV1();
		System.out.println(Arrays.toString(v1.searchRange(nums, 1)));
	}

	public int[] searchRange(int[] nums, int target) {
		int[] range = {-1, -1};

		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				int m = mid; // 临时记录往左边界
				int n = mid; // 临时记录往右边界
				range[0] = m;
				range[1] = n;

				// m > low 当 m = low 时，--m 就会发生越界
				while (m > low && nums[--m] == target) {
					range[0] = m;
				}

				// n < high 当 n = high 时，++n 就会发生越界
				while (n < high && nums[++n] == target) {
					range[1] = n;
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
