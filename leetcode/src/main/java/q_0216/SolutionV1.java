package q_0216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 *
 * @author pengbo
 * @since 2021/2/24
 */
public class SolutionV1 {

    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        List<List<Integer>> allList = solution.combinationSum3(3, 9);
        allList.forEach(System.out::println);
    }

    private final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final List<List<Integer>> result = new ArrayList<>();
    private final LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 0);
        return result;
    }

    public void backtracking(int k, int n, int sum, int startIndex) {

        if (sum > n) {
            return;
        }

        if (sum == n && path.size() < k) {
            return;
        }

        if (sum == n && path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = startIndex; i < 9; i++) {
            path.addLast(nums[i]);
            sum = sum + nums[i];
            backtracking(k, n, sum, i + 1);
            sum = sum - nums[i];
            path.removeLast();
        }
    }
}
