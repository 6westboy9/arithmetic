package q_0088;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {

	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] A = {1, 2, 3, 0, 0, 0};
		int[] B = {2, 5, 6};
		solution.merge(A, 3, B, 3);
		System.out.println(Arrays.toString(A));
	}

	public void merge(int[] A, int m, int[] B, int n) {
		int i = m - 1;
		int j = n - 1;
		int k = n + m - 1;

		if (n == 0) {
			return;
		}

		while (i >= 0 && j >= 0) {
			A[k--] = A[i] > B[j] ? A[i--] : B[j--];
		}

		while (i >= 0) {
			A[k--] = A[i--];
		}

		while (j >= 0) {
			A[k--] = B[j--];
		}
	}


}
