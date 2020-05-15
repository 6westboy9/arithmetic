package com.westboy;

/**
 * @author westboy
 * @since 2020/2/11
 */
public class Solution0005 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 2, 5};
		int[] helpArr = new int[5];
		Solution0005 solution = new Solution0005();
		System.out.println(solution.mergeSort(arr, helpArr, 0, arr.length - 1));
	}

	public int mergeSort(int[] arr, int[] helpArr, int startIndex, int endIndex) {
		int midIndex;
		if (startIndex < endIndex) {
			midIndex = startIndex + ((endIndex - startIndex) >> 1);
			return mergeSort(arr, helpArr, startIndex, midIndex) + // 对左半部分排序
				mergeSort(arr, helpArr, midIndex + 1, endIndex) + // 对右半部分排序
				merge(arr, helpArr, startIndex, midIndex, endIndex); // 使整体有序
		}
		return 0;
	}

	public int merge(int[] arr, int[] helpArr, int startIndex, int midIndex, int endIndex) {
		int left = startIndex, right = midIndex + 1, i = startIndex;
		int res = 0;
		while (left <= midIndex && right <= endIndex) {
			// 精髓
			res += arr[left] < arr[right] ? arr[left] * (endIndex - right + 1) : 0;
			helpArr[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
		}
		while (left != midIndex + 1) {
			helpArr[i++] = arr[left++];
		}
		while (right != endIndex + 1) {
			helpArr[i++] = arr[right++];
		}
		for (i = startIndex; i <= endIndex; i++) {
			arr[i] = helpArr[i];
		}
		return res;
	}
}
