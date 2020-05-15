package q_0033;

/**
 * @author westboy
 * @since 2020/1/8
 */
public class SolutionV1 {
	public static void main(String[] args) {
		// int[] nums = {4, 5, 6, 1, 2, 3};
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		// int[] nums = {4, 1, 2, 3};
		// int[] nums = {1, 2, 3};
		// int[] nums = {1, 2, 3, 4, 5};
		// System.out.println(searchV1(nums, 6));
		SolutionV1 v1 = new SolutionV1();
		System.out.println(v1.search(nums, 0));
		// System.out.println(getRotationIndex(nums));
	}

	/**
	 * 方法一：
	 * <p>
	 * 第一步，先找到旋转下标（精髓：二分法寻找），什么是旋转下标呢？比如 [1, 2, 3, 4] 旋转后为 [3, 4, 1, 2] 那么旋转下标为 2，即 1 在旋转后数组中的下标位置
	 * 第二步，旋转下标可以将其分为左右两部分有序数组，那么可以借助二分查找的思想从两部分数组中去查找目标值。
	 *
	 * @param nums   旋转后的数组
	 * @param target 目标值
	 * @return 旋转后的数组中与目标值相等的元素下标，没有找到返回 -1
	 */
	public int search(int[] nums, int target) {
		int rotationIndex = getRotationIndex(nums);
		int result = binarySearch(nums, 0, rotationIndex - 1, target);
		if (result == -1) {
			result = binarySearch(nums, rotationIndex, nums.length - 1, target);
		}
		return result;
	}

	/**
	 * 简单二分查找算法
	 *
	 * @param nums   旋转后的数组
	 * @param low    低位下标
	 * @param high   高位下标
	 * @param target 目标值
	 * @return 旋转后的数组中与目标值相等的元素下标，没有找到返回 -1
	 */
	private int binarySearch(int[] nums, int low, int high, int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	/**
	 * 使用二分法寻找旋转下标
	 *
	 * @param nums 旋转后的数组
	 * @return 旋转下标
	 */
	private int getRotationIndex(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		if (low == high) {
			return 0;
		}

		// 4, 5, 6, 1, 2, 3
		while (low < high) {
			// nums 不存在重复元素
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid + 1]) { // 找到旋转下标
				return mid + 1;
			} else {
				if (nums[low] < nums[mid]) { // 如果最左端元素小于中间元素值，说明从中间元素往左已经有序，说明旋转下标在右边
					low = mid + 1;
				} else {  // 如果最左端元素不小于中间元素值，因为没有重复元素，即最左端元素大于中间元素值，说明旋转下标在左边
					high = mid;
				}
			}
		}
		return 0;
	}
}
