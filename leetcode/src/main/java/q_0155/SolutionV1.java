package q_0155;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author pengbo.wang
 * @date 2020/07/13 5:42 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    static class MinStack {

        private final Stack<Integer> stack;
        // 辅助记录每次压栈元素，对应它之前的所有最小元素值
        // 比如压栈元素  2 0 3 0（从左往右依次压入）
        // minStack 值  2 0 0 0（弹出元素时，minStack 也依次弹出）
        private final Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            int min = minStack.isEmpty() || x <= minStack.peek() ? x : minStack.peek();
            stack.push(x);
            minStack.push(min);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
