package q_0050;

/**
 * Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        // System.out.println(solution.myPow(2, 10));
        // 2.00000
        // -2147483648
        System.out.println(solution.myPow(2, -2147483648));

        // System.out.println(Math.pow(2, 31));
        // System.out.println(3/2);
    }

    /**
     * 优化解法（推荐）
     *
     * 参考题解：https://leetcode-cn.com/problems/powx-n/solution/cdi-gui-fang-fa-ji-bai-100ti-jiao-by-zhu-ij8e/
     *
     * <p>
     * x^n=x^(n/2) * x^(n/2)
     * x^(n/2)=x^(n/4) * x^(n/4)
     * ...
     * x^2=x^1 * x^1
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        long newN = n;
        if (n < 0) {
            x = 1 / x;
            newN = -newN;
        }

        double half = myPow(x, (int) (newN / 2));
        if (newN % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
