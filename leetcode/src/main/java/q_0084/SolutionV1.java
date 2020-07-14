package q_0084;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 *
 * @author pengbo.wang
 * @date 2020/07/13 5:43 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] heights = {7, 5, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        // 使用 -1 辅助求得最长宽度时的面积
        stack.push(-1);
        int maxArea = 0;
        int i = 0;
        for (; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() -1));
            }
            stack.push(i);
        }

        // 即栈不为空
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() -1));
        }
        return maxArea;
    }

}
