import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author westboy
 * @since 2020/1/13
 */
public class Solution0225 {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack + " ---> " + stack.pop());
		System.out.println(stack + " ---> " + stack.top());
		stack.push(5);
		System.out.println(stack);
	}

	static class MyStack {
		Queue<Integer> data;
		Queue<Integer> help;

		public MyStack() {
			data = new LinkedList<>();
			help = new LinkedList<>();
		}


		public void push(int x) {
			data.add(x);
		}

		public int pop() {
			if (empty()) {
				throw new RuntimeException("Stack is empty");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}

		public int top() {
			if (empty()) {
				throw new RuntimeException("Stack is empty");
			}
			while (data.size() != 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			help.add(res);
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}

		public boolean empty() {
			return data.isEmpty();
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}
}


