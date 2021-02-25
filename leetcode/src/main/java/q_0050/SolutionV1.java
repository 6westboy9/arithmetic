package q_0050;

/**
 * Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.myPow(2, 10));
    }

    /**
     * 暴力解法
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * x;
        }

        return ans;
    }
}
