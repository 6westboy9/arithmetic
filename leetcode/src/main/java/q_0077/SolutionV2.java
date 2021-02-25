package q_0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV2 {
    // 回溯算法
    //              1     2    3   4
    //          [1]234  [2]34 [3]4 [4]_
    //        [2]34 3[4]
    //       [3]4

    // 最终的结果为 {{1,2,3},{1,2,4},{1,3,4},{2,3,4}}

    private final List<List<Integer>> result = new ArrayList<>(); // 存放符合条件结果的集合
    private final LinkedList<Integer> path = new LinkedList<>();

    /**
     * 对 v1 版本剪枝优化
     *
     * 对应视频讲解：https://www.bilibili.com/video/BV1wi4y157er
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path)); // 此处必须借助一个临时变量存储中间结果
            return;
        }

        // path.size() 已经选取的大小
        // k-path.size() 剩余还需要选取的大小
        // n - (k - path.size()) + 1 表示 i 起始的最小范围，为什么加 1 呢？举例，比如 k = 3，path.size()=1 时，i 最多取 4 - (3-1) + 1 = 3
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) { // 优化地方
            path.addLast(i);
            backtracking(n, k, i + 1); // 递归
            path.removeLast(); // 一定要弹出（回溯操作）
        }
    }

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        List<List<Integer>> result = solution.combine(4, 3);
        result.forEach(System.out::println);
    }
}
