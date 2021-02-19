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
            // 栈顶元素不是第一个元素 -1 且数组呈下降关系时，什么时候结束呢？
            // 显然是当栈顶元素为 -1 或者 heights[i] ≥ heights[stack.peek()] 跳出循环直接压栈
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                // 将栈中的序号弹出，计算最大面积
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
