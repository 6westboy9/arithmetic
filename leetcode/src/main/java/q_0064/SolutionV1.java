package q_0064;

/**
 * 最小路径和
 *
 * @author pengbo
 * @since 2020/11/18
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();

        // 左上角到右下角最短路径和
        // 只能向左或者向下移动
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid));
    }

    // m == grid.length
    // n == grid[i].length
    // 1 <= m, n <= 200
    // 0 <= grid[i][j] <= 100

    // 动态规划
    // dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
    // dp[i][0] = dp[i-1][0] + grid[i][0]
    // dp[0][j] = dp[0][j-1] + grid[0][j]
    // dp[0][0] = grid[0][0]
    public int minPathSum(int[][] grid) {
        int[][] minGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {        // 按列
            for (int j = 0; j < grid[i].length; j++) { // 按行
                if (i == 0 && j == 0) {
                    minGrid[i][j] = grid[i][j];
                }

                if (i == 0 && j > 0) {
                    minGrid[i][j] = minGrid[i][j - 1] + grid[i][j];
                }

                if (i > 0 && j == 0) {
                    minGrid[i][j] = minGrid[i - 1][j] + grid[i][j];
                }

                if (i > 0 && j > 0) {
                    minGrid[i][j] = Math.min(minGrid[i - 1][j], minGrid[i][j - 1]) + + grid[i][j];
                }
            }
        }
        return minGrid[grid.length - 1][grid[0].length - 1];
    }

}
