package q_0200;

/**
 * @author westboy
 * @since 2020/4/17
 */
public class SolutionV1 {

	public static void main(String[] args) {
		char[][] grid = {
			{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'}
		};

		SolutionV1 solution = new SolutionV1();
		System.out.println(solution.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					infect(grid, i, j);
				}
			}
		}
		return res;
	}

	private void infect(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length
			|| j < 0 || j >= grid[i].length
			|| grid[i][j] != '1') {
			return;
		}

		grid[i][j] = '2';

		infect(grid, i - 1, j);
		infect(grid, i + 1, j);
		infect(grid, i, j - 1);
		infect(grid, i, j + 1);
	}
}
