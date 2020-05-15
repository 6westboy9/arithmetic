package q_0215;

import java.util.Arrays;
import java.util.Random;

/**
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

	public int quickSelect(int[] nums, int left, int right, int kSmallest) {
		// System.out.println(Arrays.toString(nums) + ", left=" + left + ", right=" + right);

		if (left == right) {
			return nums[left];
		}
		int pivotIndex = partition(nums, left, right);
		if (kSmallest == pivotIndex) {
			return nums[kSmallest];
		} else if (kSmallest < pivotIndex) {
			return quickSelect(nums, left, pivotIndex - 1, kSmallest);
		} else {
			return quickSelect(nums, pivotIndex + 1, right, kSmallest);
		}
	}

	private int partition(int[] nums, int left, int right) {
		Random randomNum = new Random();
		int pivotIndex = left + randomNum.nextInt(right - left);
		int pivot = nums[pivotIndex];
		int storeIndex = left;

		// 将基准元素交换至最右侧
		swap(nums, pivotIndex, right);

		for (int i = left; i <= right; i++) {
			if (nums[i] < pivot) {
				swap(nums, i, storeIndex);
				storeIndex++;
			}
		}
		swap(nums, storeIndex, right);

		// int[] leftNums = new int[storeIndex];
		// int[] rightNums = new int[nums.length - storeIndex];
		// System.arraycopy(nums, 0, leftNums, 0, storeIndex);
		// System.arraycopy(nums, storeIndex, rightNums, 0, nums.length - storeIndex);
		//
		// System.out.println(Arrays.toString(nums) + ", pivot=" + pivot);
		// System.out.println(Arrays.toString(leftNums) + " " + Arrays.toString(rightNums));
		// 最终返回基准元素的位置
		return storeIndex;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}
