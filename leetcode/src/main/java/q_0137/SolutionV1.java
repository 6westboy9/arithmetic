package q_0137;

/**
 * @author pengbo.wang
 * @date 2020/07/09 4:46 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {

        SolutionV1 solution = new SolutionV1();
        int[] nums = {9,9,9,10};


        // 8421

        // 1001
        // 1001
        // 1001
        // 1010

        System.out.println(solution.singleNumber(nums));
        // System.out.println(1 << 1);
    }

    // 算法思想：每一位加起来的和能被 3 整除为 0，不能被 3 整除为 1

    // << 左移      1 << 1
    // >> 右移
    // >>> 无符号右移

    public int singleNumber(int[] nums) {
        int ans = 0;
        // int 类型总共 32 位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                // 每个元素右移一位后如果为 1，求和
                if ((num >>> i & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                // ans = ans | 1 << i 的作用通过以下示例
                // 1000 比如 i = 4 式，确定第四位为 1，即进行左移运算得到 1000
                //  110 原始 ans 为 110
                // 1110 怎么使得最终结果为 1110 呢？可以将原始的 ans 110 看作 0110，0110 | 1000 = 1110
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
