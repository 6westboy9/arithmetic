package com.westboy.chapter_08;

/**
 * 转圈打印矩阵
 *
 * @author pengbo
 * @since 2020/11/18
 */
public class Question_01 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        Question_01 question = new Question_01();
        question.spiralOrderPrint(matrix);
    }

    private void spiralOrderPrint(int[][] matrix) {
        // 记横向为 x 轴，纵向为 y 轴
        int yStart = 0;
        int xStart = 0;

        int yEnd = matrix.length - 1;
        int xEnd = matrix[0].length - 1;

        while (yStart <= yEnd && xStart <= xEnd) {
            printEdge(matrix, yStart++, xStart++, yEnd--, xEnd--);
        }
    }

    private void printEdge(int[][] matrix, int yStart, int xStart, int yEnd, int xEnd) {

        // 只有一行
        if (yStart == yEnd) {
            for (int i = xStart; i < xEnd; i++) {
                System.out.println(matrix[yStart][i] + " ");
            }
        }

        // 只有一列
        else if (xStart == xEnd) {
            for (int i = yStart; i < yEnd; i++) {
                System.out.println(matrix[xStart][i] + " ");
            }
        }

        // 一般情况
        else {
            int curYStart = yStart;
            int curXStart = xStart;

            while (curXStart < xEnd) {
                // 列固定，行向前右推进
                System.out.println(matrix[yStart][curXStart] + " ");
                curXStart++;
            }

            while (curYStart < yEnd) {
                // 行固定，列向前下推进
                System.out.println(matrix[curYStart][xEnd] + " ");
                curYStart++;
            }

            while (curXStart > xStart) {
                // 列固定，行向前左推进
                System.out.println(matrix[yEnd][curXStart] + " ");
                curXStart--;
            }

            while (curYStart > yStart) {
                // 行固定，列向前上推进
                System.out.println(matrix[curYStart][xStart] + " ");
                curYStart--;
            }
        }
    }
}
