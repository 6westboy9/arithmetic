package com.westboy;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/2/17
 */
public class Solution0006 {
	public static void main(String[] args) {
		int[] arr = {2, 5, 4, 1, 7, 3, 6};
		// int[] arr = {4, 1, 6, 3, 3, 2, 3};
		Solution0006 solution = new Solution0006();
		solution.heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void heapSort(int[] arr) {
		if (arr == null) {
			return;
		}
		int length = arr.length;
		if (length <= 1) {
			return;
		}

		// 先建立大根堆
		for (int i = 0; i < length; ++i) {
			heapInsert(arr, i);
		}
		// 循环弹出堆顶元素并 heapify
		int heapSize = length;
		// 相当于弹出堆顶元素
		swap(arr, 0, --heapSize);
		while (heapSize > 0) {
			heapify(arr, heapSize, 0);
			swap(arr, 0, --heapSize);
		}
	}

	public void heapInsert(int[] arr, int index) {
		// 当该结点大于父结点时
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			// 继续向上比较
			index = (index - 1) / 2;
		}
	}

	public void heapify(int[] arr, int heapSize, int index) {
		int leftChild = index * 2 + 1;
		// 当该结点有左孩子时
		while (leftChild < heapSize) {
			// 只有当右孩子存在且大于左孩子时，最大值是右孩子，否则是左孩子
			int greatOne = leftChild + 1 < heapSize && arr[leftChild + 1] > arr[leftChild] ? leftChild + 1 : leftChild;
			// 将父结点与最大孩子结点比较，确定最大值
			greatOne = arr[greatOne] > arr[index] ? greatOne : index;
			if (greatOne == index) {
				// 如果最大值是本身，则不用继续向下比较
				break;
			}
			swap(arr, index, greatOne);
			// 下一轮
			index = greatOne;
			leftChild = index * 2 + 1;
		}
	}

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}



