package q_0020;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.isValid("()[]{}"));
	}

	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Stack stack = new Stack(chars.length + 1);
		stack.push('?');
		for (char ch : chars) {
			// 第一步：如果是右括号弹出进行匹配
			if (ch == ')' && stack.get() == '(') {
				stack.pop();
				continue;
			}

			if (ch == '}' && stack.get() == '{') {
				stack.pop();
				continue;
			}

			if (ch == ']' && stack.get() == '[') {
				stack.pop();
				continue;
			}

			// 第二步：如果是左括号进行压栈
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				return false;
			}
		}
		return stack.pop() == '?';
	}

	static class Stack {
		char[] chars;
		int length;
		int size;

		Stack(int length) {
			this.chars = new char[length];
			this.length = length;
			this.size = 0;
		}

		void push(char ch) {
			chars[size++] = ch;
		}

		char get() {
			return chars[size - 1];
		}

		char pop() {
			return chars[--size];
		}

		boolean isEmpty() {
			return size == 0;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append(chars[i]);
			}
			return sb.toString();
		}
	}


}
