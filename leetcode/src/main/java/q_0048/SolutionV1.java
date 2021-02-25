package q_0048;

import java.util.Arrays;

/**
 * 旋转图像
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Arrays.stream(matrix).forEach(array -> System.out.println(Arrays.toString(array))); // 调整前
        solution.rotate(matrix);
        System.out.println("---------");
        Arrays.stream(matrix).forEach(array -> System.out.println(Arrays.toString(array))); // 调整后
    }

    public void rotate(int[][] matrix) {
        // tR -> dR 表示列从上到下
        // tC -> dC 表示行从左到右
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        // 一圈一圈的进行调整
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dC--, dR--);
        }
    }

    //    tC     dC
    // tR [1, 2, 3]
    //    [4, 5, 6]
    // dR [7, 8, 9]

    // 调整一圈时
    private void rotateEdge(int[][] matrix, int tR, int tC, int dC, int dR) {
        int times = dC - tC; // 调整次数
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[tR][tC + i];                       // 暂存 1
            matrix[tR][tC + i] = matrix[dR - i][tC];        // 将 7 拷贝至 1
            matrix[dR - i][tC] = matrix[dR][dC - i];        // 将 9 拷贝至 7
            matrix[dR][dC - i] = matrix[tC + i][dC];        // 将 3 拷贝至 9
            matrix[tC + i][dC] = tmp;                       // 将 1 拷贝至 3
        }
    }
}
