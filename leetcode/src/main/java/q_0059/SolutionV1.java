package q_0059;

import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
	}

	private int i = 1;

	// 注意 n 为正整数
	public int[][] generateMatrix(int n) {
		int minRow = 0;
		int minColumn = 0;
		int maxRow = n - 1;
		int maxColumn = maxRow;

		int[][] matrix = new int[n][n];

		while (minRow <= maxRow && minColumn <= maxColumn) {
			edge(matrix, minRow++, minColumn++, maxRow--, maxColumn--);
		}
		return matrix;
	}

	private void edge(int[][] matrix, int minRow, int minColumn, int maxRow, int maxColumn) {
		// 不存在单行与单列的情况
		int curRow = minRow;
		int curColumn = minColumn;


		while (curColumn != maxColumn) {
			matrix[curRow][curColumn] = i++;
			curColumn++;
		}
		while (curRow != maxRow) {
			matrix[curRow][curColumn] = i++;
			curRow++;
		}
		while (curColumn != minColumn) {
			matrix[curRow][curColumn] = i++;
			curColumn--;
		}
		while (curRow != minRow) {
			matrix[curRow][curColumn] = i++;
			curRow--;
		}

		// 考虑 n 为奇数时
		if (minRow == maxRow && minColumn == maxColumn) {
			matrix[curRow][curColumn] = i++;
		}
	}

}
