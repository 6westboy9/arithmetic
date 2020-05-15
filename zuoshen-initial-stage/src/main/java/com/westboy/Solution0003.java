package com.westboy;

import java.util.Arrays;

/**
 * 荷兰国旗
 *
 * @author westboy
 * @since 2020/1/2
 */
public class Solution0003 {

	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 5, 6, 2};
		// int[] arr = {4, 2, 3, 5, 2, 3, 1, 7};
		solution1(arr, 4);
		// solution2(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 给定一个数组 arr 和一个数 num，请把小于等于 num 的数放在数组的左边，大于 num 的数放在数组的右边。
	 * <p>
	 * 要求额外空间复杂度 O(1)，时间复杂度 O(n)
	 */
	public static void solution1(int[] arr, int target) {
		int i = -1;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] <= target) {
				swap(arr, ++i, j);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	/**
	 * 荷兰国旗问题
	 * <p>
	 * 给定一个数组 arr 和一个数 num，请把小于 num 的数放在数组的左边，等于 num 的数放在数组的中间，大于 num 的数放在数组的右边。
	 * <p>
	 * 要求额外空间复杂度 O(1)，时间复杂度 O(n)
	 */
	public static void solution2(int[] arr, int target) {
		int less = -1;
		int more = arr.length;
		int j = 0;
		while (j < more) {
			if (arr[j] < target) {
				swap(arr, ++less, j++);
			} else if (arr[j] > target) {
				swap(arr, --more, j);
			} else {
				j++;
			}
		}
	}


}
