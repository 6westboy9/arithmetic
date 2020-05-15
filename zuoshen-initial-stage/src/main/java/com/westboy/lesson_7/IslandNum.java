package com.westboy.lesson_7;

import java.util.Arrays;

/**
 * 岛问题
 *
 * @author westboy
 * @since 2020/4/17
 */
public class IslandNum {

	public static int getIslandNums(int[][] matrix) {
		int res = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					res++;
					infect(matrix, i, j);
					System.out.println(Arrays.deepToString(matrix));
				}

			}
		}
		return res;
	}

	// 感染函数
	public static void infect(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] != 1) {
			return;
		}
		matrix[i][j] = 2;
		// 感染左
		infect(matrix, i - 1, j);
		// 感染右️
		infect(matrix, i + 1, j);
		// 感染上
		infect(matrix, i, j - 1);
		// 感染下
		infect(matrix, i, j + 1);
	}

	public static void main(String[] args) {
		// int[][] matrix = {
		// 	{1, 0, 0, 1, 0, 1},
		// 	{0, 1, 1, 0, 0, 0},
		// 	{1, 0, 0, 0, 1, 1},
		// 	{1, 1, 1, 1, 1, 1}
		// };

		int[][] matrix = {
			{1, 0, 1},
			{0, 1, 0},
			{1, 1, 1}
		};

		System.out.println(getIslandNums(matrix));
	}
}
