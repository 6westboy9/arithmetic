package q_0062;

public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.uniquePaths(3, 7));
    }


    // 动态方程：dp[i][j]=dp[i-1][j]+dp[i][j-1]
    // 对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }

}
