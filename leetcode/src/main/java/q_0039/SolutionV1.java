package q_0039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 *
 * @author pengbo
 * @since 2021/2/23
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] candidates = {2,3,6,7};
        int target = 7;
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> nums = new LinkedList<>();
        combinationSum(candidates, 0, target, nums);
        return allNums;
    }

    // 7-2=5
    // 5-2=3
    // 3-3=0

    // 7-7=0
    private void combinationSum(int[] candidates, int j,  int target, LinkedList<Integer> nums) {
        // j 变量用作控制去重
        for (int i = j; i < candidates.length; i++) {
            int temp = target - candidates[i];
            if (temp < 0) {
                break;
            }

            if (temp == 0) {
                LinkedList<Integer> tempNums = new LinkedList<>(nums);
                tempNums.addLast(candidates[i]);
                allNums.add(tempNums);
                break;
            }

            if (temp >= candidates[i]) {
                nums.add(candidates[i]);
                combinationSum(candidates, j++, temp, nums);
                nums.removeLast();
            }
        }
    }
}
