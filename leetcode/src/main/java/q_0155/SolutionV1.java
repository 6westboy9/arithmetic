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
