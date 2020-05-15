import java.util.Stack;

/**
 * @author westboy
 * @since 2020/1/13
 */
public class Solution0232 {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.peek());
		queue.push(4);
		queue.push(5);
		System.out.println(queue.peek());
	}

	static class MyQueue {

		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;

		public MyQueue() {
			pushStack = new Stack<>();
			popStack = new Stack<>();
		}

		public void push(int x) {
			pushStack.push(x);
		}

		public int pop() {
			if (empty()) {
				throw new RuntimeException("Queue is empty.");
			} else if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					// 将 pushStack 中的数据导入 popStack
					popStack.push(pushStack.pop());
				}
			}

			return popStack.pop();
		}

		public int peek() {
			if (empty()) {
				throw new RuntimeException("Queue is empty.");
			} else if (popStack.isEmpty()) {
				// 将 pushStack 中的数据导入 popStack
				while (!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
			return popStack.peek();
		}

		public boolean empty() {
			return pushStack.isEmpty() && popStack.isEmpty();
		}
	}
}