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
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] candidates = {4, 4, 2, 1, 4, 2, 2, 1, 3};
        int target = 6;
        List<List<Integer>> allList = solution.combinationSum2(candidates, target);
        // allList.forEach(System.out::println);
    }


    // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    // 所求解集为:
    // [
    //   [1, 7],
    //   [1, 2, 5],
    //   [2, 6],
    //   [1, 1, 6]
    // ]

    // 排序后：[1, 1, 2, 5, 6, 7, 10]
    private final List<List<Integer>> allNums = new ArrayList<>();

    /**
     * 借助 0039 的思想
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> nums = new LinkedList<>();
        combinationSum2(candidates, 0, target, nums);
        return allNums;
    }

    private void combinationSum2(int[] candidates, int j, int target, LinkedList<Integer> nums) {
        // j 变量和 preNum 的作用是去重
        int preNum = 0;
        for (int i = j; i < candidates.length; i++) {

            if (candidates[i] == preNum) {
                ++j;
                continue;
            }

            int temp = target - candidates[i];
            if (temp < 0) {
                break;
            }

            if (temp == 0) {
                LinkedList<Integer> tempNums = new LinkedList<>(nums);
                tempNums.addLast(candidates[i]);
                System.out.println(tempNums);
                allNums.add(tempNums);
                break;
            }

            if (temp >= candidates[i]) {
                nums.add(candidates[i]);
                combinationSum2(candidates, ++j, temp, nums);
                preNum = nums.removeLast();
            }
        }
    }
}
