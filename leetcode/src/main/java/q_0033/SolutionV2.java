package q_0033;

/**
 * @author westboy
 * @since 2020/1/19
 */
public class SolutionV2 {

	public static void main(String[] args) {
		// int[] nums = {4, 5, 6, 1, 2, 3};
		// int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int[] nums = {4, 1, 2, 3};
		// int[] nums = {1, 2, 3};
		// int[] nums = {1, 2, 3, 4, 5};
		// System.out.println(searchV1(nums, 6));
		SolutionV2 v2 = new SolutionV2();
		System.out.println(v2.search(nums, 2));
		// System.out.println(getRotationIndex(nums));
	}

	/**
	 * 方法二（易理解，推荐）
	 *
	 * @param nums   旋转后的数组
	 * @param target 目标值
	 * @return 旋转后的数组中与目标值相等的元素下标，没有找到返回 -1
	 */
	public int search(int[] nums, int target) {
		int low = 0;                // nums 数据起始下标
		int high = nums.length - 1; // nums 数组截止下标

		while (low <= high) {
			// nums 为奇数个数时，[4, 5, 1, 2, 3] 中间元素为 1
			// nums 为偶数个数时，[4, 1, 2, 3] 中间元素为 1
			int mid = (low + high) / 2;

			System.out.println("中间元素下标:" + mid + ", 值:" + nums[mid]);

			// ①
			if (nums[mid] == target) {
				System.out.println("中间元素下标对应值与目标值相等, 返回中间元素下标:" + mid);
				return mid;
			}

			// 中间元素值大于最左元素值，左边元素均有序
			// 注意此处的 = 情况，假设此时为 > ，不包含 =，比如 nums=[5, 4]，target=4 时，会出错
			// = 的情况只有为两个元素时才会出现，因为数组元素值的前提是无重复元素值，只有数组元素为两个时，会存在 nums[mid] = nums[low] 的情况
			// 此处加了 = 后刚好可以处理这种特殊情况

			// 思路：先找到中间元素，观察左右区间是否有序
			// 左区间有序，判断目标元素是否在左区间，如果在，high = mid - 1；如果不在，low = mid + 1
			// 右区间有序，判断目标元素是否在右区间，如果在，low = mid + 1；如果不在，high = mid - 1

			// mid 左边有序
			if (nums[mid] >= nums[low]) {
				// 目标值在左边有序部分，其中 target == nums[mid] 已经在 ① 统一处处理
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1; // 目标值在右边数组中
				}
			}

			// mid 右边有序
			// 否则 nums[mid] < nums[low]，右边有序 [4,1,2,3] nums[mid]=1 nums[low]=3
			else {
				// 目标值在右边有序部分，其中 target == nums[mid] 已经在 ① 统一处处理
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1; // 目标值在左边数组中
				}
			}
		}
		return -1;
	}

	/**
	 * 上述方法的另一种实现方法
	 *
	 * @param nums   旋转后的数组
	 * @param target 目标值
	 * @return 旋转后的数组中与目标值相等的元素下标，没有找到返回 -1
	 */
	public int searchV2(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			// ①
			if (nums[mid] == target) {
				return mid;
			}

			// 中间元素值大于最左元素值，左边元素均有序
			// 注意此处的 = 情况，假设此时为 > ，不包含 =，比如 nums=[5, 4]，target=4 时，会出错
			// = 的情况只有为两个元素时才会出现，因为数组元素值的前提是无重复元素值，只有数组元素为两个时，会存在 nums[mid] = nums[low] 的情况
			// 特殊处理
			if (nums[mid] == nums[low]) {
				return nums[low] == target ? low : nums[high] == target ? high : -1;
			} else if (nums[mid] > nums[low]) {
				// 目标值在左边有序部分，其中 target == nums[mid] 已经在 ① 统一处处理
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					// 目标值在右边循环数组中
					low = mid + 1;
				}
			} else { // 否则，右边有序
				//	目标值在右边有序部分，其中 target == nums[mid] 已经在 ① 统一处处理
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					// 目标值在左边循环数组中
					high = mid - 1;
				}
			}
		}

		return -1;
	}
}
