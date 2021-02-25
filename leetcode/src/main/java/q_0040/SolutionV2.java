package q_0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        // int[] candidates = {4, 4, 2, 1, 4, 2, 2, 1, 3};
        // int target = 6;
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> allList = solution.combinationSum2(candidates, target);
        allList.forEach(System.out::println);
    }


    // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    // 所求解集为:
    // [
    //   [1, 7],
    //   [1, 2, 5],
    //   [2, 6],
    //   [1, 1, 6]
    // ]

    private final List<List<Integer>> allNums = new ArrayList<>();
    private final LinkedList<Integer> nums = new LinkedList<>();

    /**
     * 回溯思想
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length]; // 去重（精髓，画图好好理解）
        Arrays.sort(candidates); // 排序
        backtracking(candidates, target, 0, 0, used);
        return allNums;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum, boolean[] used) {
        if (sum == target) {
            allNums.add(new LinkedList<>(nums));
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (sum + candidates[i] > target) {
                continue;
            }

            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            sum = sum + candidates[i];
            nums.addLast(candidates[i]);
            used[i] = true;
            backtracking(candidates, target, i + 1, sum, used);
            used[i] = false;
            sum = sum - candidates[i];
            nums.removeLast();
        }
    }
}
