package com.westboy;

import java.util.Arrays;

/**
 * 无序数组 B 中找出不属于有序数组 A 的数
 *
 * @author westboy
 * @since 2019/12/30
 */
public class Solution0001 {
	public static void main(String[] args) {
		int A[] = {1, 2, 3, 4, 5};
		int B[] = {1, 4, 2, 6, 5, 7};
		// searchV1(A, B);
		// searchV2(A, B);
		searchV3(A, B);
	}

	public static void searchV1(int[] A, int[] B) {
		for (int i = 0; i < B.length; ++i) {
			int temp = B[i];
			boolean flag = false;
			for (int j = 0; j < A.length; ++j) {
				if (A[j] == temp) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(temp);
			}
		}
	}

	public static void searchV2(int[] A, int[] B) {
		for (int i = 0; i < B.length; ++i) {
			int temp = B[i];
			//二分法查找
			int left = 0, right = A.length - 1;
			int mid = (left + right) / 2;
			while (left < right && A[mid] != temp) {
				if (A[mid] > temp) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
				mid = (left + right) / 2;
			}
			if (A[mid] != temp) {
				System.out.println(temp);
			}
		}
	}


	public static void searchV3(int[] A, int[] B) {
		Arrays.sort(B);
		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] == B[j]) {
				j++;
			} else if (A[i] < B[j]) {
				i++;
			} else {
				System.out.println(B[j]);
				j++;
			}
		}

		while (j < B.length) {
			System.out.println(B[j]);
			j++;
		}
	}

}
