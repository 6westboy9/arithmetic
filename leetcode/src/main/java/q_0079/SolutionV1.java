package q_0079;

/**
 * 单词搜索
 *
 * @author pengbo
 * @since 2021/2/25
 */
public class SolutionV1 {


    // board =
    // [
    //   ['A','B','C','E'],
    //   ['S','F','C','S'],
    //   ['A','D','E','E']
    // ]
    //
    // 给定 word = "ABCCED", 返回 true
    // 给定 word = "SEE", 返回 true
    // 给定 word = "ABCB", 返回 false
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.exist(board, "ABCCED"));
    }


    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 四个遍历方向
    private int rows; // 二维数组行数
    private int cols; // 二维数组列数
    private int len;  // 单词长度
    private boolean[][] visited; // 遍历足迹
    private char[] charArray; // 单词数组
    private char[][] board; // 二维数组

    /**
     * 参考题解：https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
     */
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false; // 二维数组为空
        }

        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;

        // ======================= 上述都是初始化数据 =======================

        // 开始遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int begin) {
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }

        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;

            // 四个方向
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // 还在区域内 && 没有遍历过
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    // 推进 begin
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }

            // 回溯
            visited[x][y] = false;
        }
        return false;
    }

    // 还在区域内
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
