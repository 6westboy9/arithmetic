package q_0070;

/**
 * @author westboy
 * @since 2020/2/10
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.climbStairs(5));
    }

    // f(1)=1
    //
    // 		1
    //
    // f(2)=2
	//
    // 		1 + 1
    // 		2
    //
    // f(3)=3
	//
    // 		1 + 1 + 1
    // 		1 + 2
    // 		2 + 1
    //
    //
    // f(4)=5
    //
    // 		1 + 1 + 1 + 1
    // 		1 + 2 + 1
    // 		1 + 1 + 2
    // 		2 + 1 + 1
    // 		2 + 2

	// 找 最近 重复子问题

	// 方法一（递归）

    // f(n) = f(n-1) + f(n-2)
    // public int climbStairs(int n) {
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }


	// 方法二
	// 找最近重复子问题
	// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

	// 参考题解：https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/

	// 本问题其实常规解法可以分成多个子问题，爬第 n 阶楼梯的方法数量，等于 2 部分之和
	//
	// - 爬上 n-1 阶楼梯的方法数量。因为再爬 1 阶就能到第 n 阶
	// - 爬上 n-2 阶楼梯的方法数量，因为再爬 2 阶就能到第 n 阶

	// 所以我们得到公式 dp[n] = dp[n-1] + dp[n-2]
	// 同时需要初始化 dp[0]=1 和 dp[1]=1
	// 时间复杂度：O(n)
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int pre1 = 1;
		int pre2 = 2;
		for (int i = 3; i <= n; i++) {
			int cur = pre1 + pre2;
			pre1 = pre2;
			pre2 = cur;
		}
		return pre2;
	}

}
