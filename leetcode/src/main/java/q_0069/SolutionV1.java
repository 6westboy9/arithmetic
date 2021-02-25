package q_0069;

/**
 * x 的平方根
 *
 * @author pengbo
 * @since 2021/2/24
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.mySqrt(8));

    }

    // 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        int ans = -1;
        while (left <= right) {
            int mid = left + ((right - 1) / 2);
            if ((long) (mid * mid) <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
