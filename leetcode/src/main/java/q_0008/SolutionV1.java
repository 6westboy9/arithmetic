package q_0008;

/**
 * @author westboy
 * @since 2020/4/22
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.myAtoi("   -42"));
	}

	public int myAtoi(String str) {
		int res = 0;
		boolean negative = false;
		boolean hasSkip = false;
		char ca = ' ';
		// 以下两个变量用于存储在遍历过程中 res 和 y 的临界值
		// 当 x 为负数时，Integer.MIN_VALUE = -(maxRes * 10 + 8)
		// 当 x 为正数时，Integer.MAX_VALUE = maxRes * 10 + 7
		int maxRes = Integer.MAX_VALUE / 10;
		for (char ch : str.toCharArray()) {
			if (ch == ' ' && res == 0 && !hasSkip) {
				continue;
			}

			if (ch == '-') {
				if (ca == ' ' && res == 0 && !hasSkip) {
					ca = '-';
					hasSkip = true;
					negative = true;
					continue;
				} else {
					break;
				}
			}

			if (ch == '+') {
				if (ca == ' ' && res == 0 && !hasSkip) {
					ca = '+';
					hasSkip = true;
					negative = false;
					continue;
				} else {
					break;
				}
			}

			if (ch == '0' && res == 0) {
				hasSkip = true;
				continue;
			}

			// '0' = 48，'9' = 57
			if (ch >= '0' && ch <= '9') {
				// 当大于临界值时，直接返回 0
				if (res > maxRes || (res == maxRes && (short) ch - 48 > (negative ? 8 : 7))) {
					return negative ? 0x80000000 : 0x7fffffff;
				}
				res = res * 10 + (short) ch - 48;
			} else {
				break;
			}
		}
		return negative ? -res : res;
	}
}
