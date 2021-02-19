package q_0085;

/**
 * 最大矩阵
 *
 * @author pengbo
 * @since 2020/11/18
 */
public class SolutionV1 {
    public static void main(String[] args) {
       SolutionV1 solution = new SolutionV1();

        // 左上角到右下角最短路径和
        // 只能向左或者向下移动
        char[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(solution.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {

        return 0;
    }
}
