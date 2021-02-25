package q_0055;

/**
 * 跳跃游戏
 *
 * @author pengbo
 * @since 2021/2/24
 */
public class SolutionV1 {

    // 输入：nums = [2,3,1,1,4]
    // 输出：true
    // 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

    // 输入：nums = [3,2,1,0,4]
    // 输出：false
    // 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

    // 1 <= nums.length <= 3 * 10^4
    // 0 <= nums[i] <= 10^5
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        // int[] nums = {3, 2, 1, 0, 4};
        int[] nums = {2, 3, 1, 1, 4};
        // int[] nums = {0, 1};
        // int[] nums = {2,5,0,0};
        // int[] nums = {2, 0};
        System.out.println(solution.canJump(nums));
    }


    /**
     * 参考题解：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/ 官方题解
     */
    public boolean canJump(int[] nums) {
        int reach = 0; // 表示当前元素所能到达的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (reach < i) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }


}
