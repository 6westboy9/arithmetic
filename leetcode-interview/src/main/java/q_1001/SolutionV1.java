package q_1001;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/3/3
 */
public class SolutionV1 {
	public static void main(String[] args) {
		// int[] A = {1, 2, 3, 0, 0, 0};
		// int[] B = {2, 5, 6};

		int[] A = {2, 0};
		int[] B = {1};
		SolutionV1 solution = new SolutionV1();
		solution.merge(A, 1, B, 1);
		System.out.println(Arrays.toString(A));
	}


	public void merge(int[] A, int m, int[] B, int n) {
		int[] temp = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;

		if (n == 0) {
			return;
		}

		while (i < m && j < n) {
			temp[k++] = A[i] < B[j] ? A[i++] : B[j++];
		}

		while (i < m) {
			temp[k++] = A[i++];
		}

		while (j < n) {
			temp[k++] = B[j++];
		}
		System.arraycopy(temp, 0,  A, 0, m + n);
	}
}
