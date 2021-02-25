package q_0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result =  solution.permute(nums);
        result.forEach(System.out::println);
    }

    private final List<List<Integer>> result = new ArrayList<>(); // 存放符合条件结果的集合
    private final LinkedList<Integer> path = new LinkedList<>();

    /**
     * 回溯算法
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
