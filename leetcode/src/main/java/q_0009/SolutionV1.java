package q_0009;

import java.util.Arrays;

/**
 * 回文数
 * @author pengbo
 * @since 2021/2/20
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.isPalindrome(1121));
    }

    public boolean isPalindrome(int x) {
        int t = x;
        if (x < 0) {
            return false;
        }

        int len = 0;
        while (x > 0) {
            len++;
            x = x / 10;
        }

        System.out.println(len);

        int[] nums = new int[len];
        int numsIdx = 0;
        int y = t;
        while (y > 0) {
            nums[numsIdx++] = y % 10;
            y = y / 10;
        }

        System.out.println(Arrays.toString(nums));

        // 121  len=3 3/2=1 left=1 right=1
        // 1221 len=4 4/2=2 left=1 right=2

        int right = len / 2;
        int left = len % 2 == 0 ? right - 1 : right;

        System.out.println(left);
        System.out.println(right);
        while (left >= 0 && right <= len - 1) {
            if (nums[left] != nums[right]) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
