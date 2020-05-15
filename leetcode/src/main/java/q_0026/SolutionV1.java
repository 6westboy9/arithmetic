package q_0026;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] nums = {0, 0, 1, 2, 2, 3};

		// 利用的思想就是向右推，保证 ] 以左的都是无重复的

		// 使用 left 指针指向 ] 左侧的第一个元素位置，指针 i 从 1 开始遍历，将 nums[left] 与 nums[i] 进行比较
		// 如果相同，则 i 指针继续向右遍历，即 i++；
		// 如果不同，则将此时 i 指针指向的的元素与 left 右侧第一个元素交换，并将 left 的边界向右扩充一位，即 swap(nums, i, ++left)；
		// 遍历结束后，left 左侧（包括 left）的均为有序无重复元素数组，相应的返回结果为 left + 1。

		// 0] 0, 1, 2, 2, 3
		// 0, 1] 0, 2, 2, 3
		// 0, 1, 2] 0, 2, 3
		// 0, 1, 2, 3] 2, 0

		System.out.println(solution.removeDuplicates(nums));
	}

	// 利用的思想
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int left = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[left] != nums[i]) {
				swap(nums, i, ++left);
			}
			System.out.println(Arrays.toString(nums));
		}
		return left + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
