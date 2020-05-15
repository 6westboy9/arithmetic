package com.westboy.C_16;


import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/1/9
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		Arrays.sort(arr);
		// 1, 2, 3, 4, 5, 6
		// System.out.println(5/2);
		// System.out.println(5>>1);
		System.out.println(simpleBinarySearch(arr, 5));
	}

	/**
	 * 一个简单的二分查找算法
	 *
	 * @param nums    给定需要查找的数组，数组元素已经排好序并且没有重复元素
	 * @param target 给定需要查找的值
	 * @return 查找到对应元素在数组中的索引，如果没有查找到返回 -1
	 */
	private static int simpleBinarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			// 等效于 int mid = (start + end) / 2; 并且可以防止 start + end 越界
			mid = start + ((end - start) >> 1);
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}


}
