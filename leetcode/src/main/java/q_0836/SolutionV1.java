package q_0836;

/**
 * @author westboy
 * @since 2020/3/18
 */
public class SolutionV1 {
	public static void main(String[] args) {
		SolutionV1 solution = new SolutionV1();
		int[] rec1 = {0, 0, 2, 2};
		int[] rec2 = {1, 1, 3, 3};
		System.out.println(solution.isRectangleOverlap(rec1, rec2));

	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
			Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
	}
}
