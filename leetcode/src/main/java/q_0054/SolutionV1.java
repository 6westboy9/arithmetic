package q_0054;

import java.util.ArrayList;
import java.util.List;

/**
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		// int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(solution.spiralOrder(matrix));
	}

	List<Integer> list = new ArrayList<>();

	public List<Integer> spiralOrder(int[][] matrix) {

		if (matrix.length == 0) {
			return list;
		}

		// 最大列数
		int maxColumn = matrix[0].length - 1;
		// 最大行数
		int maxRow = matrix.length - 1;
		// 初始行数、列数
		int minRow = 0, minColumn = 0;

		while (minRow <= maxRow && minColumn <= maxColumn) {
			edge(matrix, minRow++, minColumn++, maxRow--, maxColumn--);
		}
		return list;
	}

	/**
	 * @param matrix    矩阵
	 * @param minRow    子矩阵最小行下标
	 * @param minColumn 子矩阵最小列下标
	 * @param maxRow    子矩阵最大行下标
	 * @param maxColumn 子矩阵最大列下标
	 */
	public void edge(int[][] matrix, int minRow, int minColumn, int maxRow, int maxColumn) {
		// 特殊情况一：子矩阵只有一行时
		if (minRow == maxRow) {
			// 行固定，遍历列元素
			for (int i = minColumn; i <= maxColumn; i++) {
				list.add(matrix[minRow][i]);
			}
		}
		// 特殊情况二：子矩阵只有一列时
		else if (minColumn == maxColumn) {
			// 列固定，遍历行元素
			for (int i = minRow; i <= maxRow; i++) {
				list.add(matrix[i][minColumn]);
			}
		}
		// 正常情况
		else {
			int curRow = minRow;
			int curColumn = minColumn;

			// 遍历顺序
			//   ---→ |
			//   ↑    ↓
			//   | ←---

			// →
			while (curColumn != maxColumn) {
				list.add(matrix[curRow][curColumn]);
				curColumn++;
			}

			// ↓
			while (curRow != maxRow) {
				list.add(matrix[curRow][curColumn]);
				curRow++;
			}

			// ←
			while (curColumn != minColumn) {
				list.add(matrix[curRow][curColumn]);
				curColumn--;
			}

			// ↑
			while (curRow != minRow) {
				list.add(matrix[curRow][curColumn]);
				curRow--;
			}
		}
	}

}
