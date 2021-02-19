package q_0022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengbo.wang
 * @date 2020/07/27 9:40 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        List<String> ans = solution.generateParenthesis(3);
        ans.forEach(System.out::println);
    }

    private final List<String> ans = new ArrayList<>();

    // 第一步先求得所有组合
    // public void generate(int level, int max, String s) {
    //     if (level > max) {
    //         ans.add(s);
    //         return;
    //     }
    //     generate(level + 1, max, s + "(");
    //     generate(level + 1, max, s + ")");
    // }
    //
    // public List<String> generateParenthesis(int n) {
    //     generate(1, 2 * n, "");
    //     return ans;
    // }

    // 第二步再进行优化
    // 左括号 可以随时加，只要不超标
    // 右括号 必须之前有左括号，且左括号个数 > 右括号个数
    public void generate(int left, int right, int n, String s) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return ans;
    }

}
