package q_0070;

import javax.sound.midi.Soundbank;

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
    // 		1 + 1
    // 		2
    //
    // f(3)=3
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

    // f(n) = f(n-1) + f(n-2)
    // public int climbStairs(int n) {
    //     if (n == 1) return 1;
    //     if (n == 2) return 2;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }

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
