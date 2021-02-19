package q_0042;

/**
 * 接雨水
 *
 * @author westboy
 * @since 2020/4/26
 */
public class SolutionV2 {

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }


    /**
     * 核心思想：找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。所以分为两步实现：
     * <P>
     * 第一步：通过两次遍历求分别求得每个元素左边的最大高度和右边的最大高度
     * <P>
     * 第二步：再次遍历累加计算每个元素所能达到的最高位置
     */
    public int trap(int[] height) {

        // 步骤一：一次循环，求得每个元素左边最高高度
        int temp = 0;
        int len = height.length;
        int[] helperLeft = new int[len];
        for (int i = 0; i < len; i++) {
            if (height[i] > temp) {
                // temp 暂存当前元素左边界最高高度
                temp = height[i];
            }
            helperLeft[i] = temp;
        }

        // 步骤二：一次循环，求得每个元素右边最高高度
        temp = 0;
        int[] helperRight = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (height[i] > temp) {
                temp = height[i];
            }
            helperRight[i] = temp;
        }

        // System.out.println(Arrays.toString(helperLeft));
        // System.out.println(Arrays.toString(height));
        // System.out.println(Arrays.toString(helperRight));

        // 步骤三：再次遍历累加计算每个元素所能达到的最高位置
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 当前元素的高度 = Math.min(helperLeft[i], helperRight[i]) - height[i]
            res += Math.min(helperLeft[i], helperRight[i]) - height[i];
        }
        return res;
    }
}
