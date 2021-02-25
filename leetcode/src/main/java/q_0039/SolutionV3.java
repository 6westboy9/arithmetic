package q_0039;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV3 {
    public static void main(String[] args) {
        SolutionV3 solution = new SolutionV3();
        // int[] candidates = {2, 3, 6, 7};
        // int target = 7;
        int[] candidates = {2, 7, 6, 3, 5, 1};
        int target = 9;
        List<List<Integer>> allList = solution.combinationSum(candidates, target);
        allList.forEach(System.out::println);
    }


    // 输入：candidates = [2,3,6,7], target = 7,
    // 所求解集为：
    // [
    //   [7],
    //   [2,2,3]
    // ]

    // 1 <= candidates.length <= 30
    // 1 <= candidates[i] <= 200
    // candidate 中的每个元素都是独一无二的。
    // 1 <= target <= 500
    private final List<List<Integer>> allNums = new ArrayList<>();
    private final LinkedList<Integer> nums = new LinkedList<>();

    /**
     * 解法参考自：https://mp.weixin.qq.com/s/HX7WW6ixbFZJASkRnCTC3w
     * 推荐（回溯算法）相较于 V2 版本进行剪枝优化
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return allNums;
    }

    private void backtracking(int[] candidates, int target, int statIndex, int sum) {
        // 优化点：在 for 循环条件判断进行优化，直接禁止进入下一轮迭代，即使下一轮迭代会进行判断并返回
        // if (sum > target) {
        //     return;
        // }

        if (sum == target) {
            allNums.add(new LinkedList<>(nums));
            return;
        }

        for (int i = statIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            sum = sum + candidates[i];
            nums.addLast(candidates[i]);
            backtracking(candidates, target, i, sum);
            sum = sum - candidates[i];
            nums.removeLast();
        }
    }
}
