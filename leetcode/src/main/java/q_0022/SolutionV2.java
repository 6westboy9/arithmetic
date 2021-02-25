package q_0022;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author pengbo.wang
 * @date 2020/07/27 9:40 下午
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        List<String> ans = solution.generateParenthesis(3);
        ans.forEach(System.out::println);
    }

    private final List<String> ans = new ArrayList<>();
    private final StringBuilder path = new StringBuilder();

    /**
     * 回溯算法
     */
    public List<String> generateParenthesis(int n) {
        backtracking(0, 0, n);
        return ans;
    }

    private void backtracking(int open, int close, int n) {
        if (path.length() == n * 2) {
            ans.add(path.toString());
            return;
        }

        if (open < n) {
            path.append("(");
            backtracking(open + 1, close, n);
            path.deleteCharAt(path.length() - 1);
        }

        if (close < open) {
            path.append(")");
            backtracking(open, close + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
