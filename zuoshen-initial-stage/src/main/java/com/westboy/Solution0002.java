package com.westboy;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author westboy
 * @since 2019/12/30
 */
public class Solution0002 {


	public static void main(String[] args) {
		int[] arr = {2, 5, 4, 1, 7, 3, 6};
		// int[] arr = {4, 1, 6, 3, 3, 2, 3};
		quickSortV2(arr);
		System.out.println(Arrays.toString(arr));
	}


	public static int[] bubbleSort(int[] arr) {
		if (arr.length == 0 || arr.length == 1) {
			return arr;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			boolean flag = true;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = false;
				}
			}

			if (flag) {
				break;
			}
		}
		return arr;
	}

	public static int[] selectSort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			int tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
		return arr;
	}

	public static int[] insertSortV1(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}

		for (int i = 1; i < arr.length - 1; i++) {
			// 因为 i 最小为 1，j 的起始位置又是 i，所以 j-1 是不会小于 0 的，所以不会发生越界
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				} else {
					break;
				}
			}
		}

		return arr;
	}

	public static int[] insertSortV2(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}

		for (int i = 1; i < arr.length - 1; i++) {
			// 找到插入的位置，再进行交换
			int v = arr[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (arr[j] > v) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}

			// 注意 for 循环，最终会多往前走一步需要回退
			arr[j + 1] = v;
		}

		return arr;
	}


	public static int[] mergeSortV1(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		return mergeSortV1(arr, 0, arr.length - 1);
	}


	public static int[] mergeSortV1(int[] arr, int left, int right) {
		if (left >= right) {
			return new int[]{arr[left]};
		}

		int mid = left + ((right - left) / 2);
		// int mid = (left + right) / 2;
		int[] leftArr = mergeSortV1(arr, left, mid);
		int[] rightArr = mergeSortV1(arr, mid + 1, right);
		return mergeV1(leftArr, rightArr);
	}

	private static int[] mergeV1(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;

		int[] arr = new int[arr1.length + arr2.length];

		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			arr[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
		}

		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}

		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}
		return arr;
	}

	public static void mergeSortV2(int[] arr) {
		mergeSortV2(arr, 0, arr.length);
	}


	public static void mergeSortV2(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = left + ((right - left) / 2);
		mergeSortV2(arr, left, mid);
		mergeSortV2(arr, mid + 1, right);
		mergeV2(arr, left, mid, right);
	}

	private static void mergeV2(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int p1 = left;
		int p2 = mid + 1;
		int i = 0;
		while (p1 <= mid && p2 <= right) {
			temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}

		while (p1 <= mid) {
			temp[i++] = arr[p1++];
		}

		while (p2 <= right) {
			temp[i++] = arr[p2++];
		}

		for (int value : temp) {
			arr[left++] = value;
		}
	}


	public static void quickSortV2(int[] arr) {
		quickSortV2(arr, 0, arr.length - 1);
	}

	// public static void quickSortV1(int[] arr, int left, int right) {
	// 	if (left < right) {
	// 		int[] p = partitionV1(arr, left, right);
	// 		quickSortV2(arr, left, p[0] - 1);
	// 		quickSortV2(arr, p[1] + 1, right);
	// 	}
	// }


	public static void quickSortV2(int[] arr, int left, int right) {
		if (left < right) {
			// 随机快排
			swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
			int[] p = partitionV2(arr, left, right);
			quickSortV2(arr, left, p[0] - 1);
			quickSortV2(arr, p[1] + 1, right);
		}
	}

	private static int[] partitionV2(int[] arr, int left, int right) {
		int less = left - 1;
		int more = right;
		int current = left;
		while (current < more) {
			if (arr[current] < arr[right]) {
				swap(arr, ++less, current++);
			} else if (arr[current] > arr[right]) {
				swap(arr, --more, current);
			} else {
				current++;
			}
		}
		swap(arr, more, right);
		return new int[]{less + 1, more};
	}


	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
