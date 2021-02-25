package q_0078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * @author pengbo
 * @since 2021/2/25
 */
public class SolutionV1 {

    public static void main(String[] args) {

        // 输入：nums = [1,2,3]
        // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        // 输入：nums = [0]
        // 输出：[[],[0]]
        SolutionV1 solution = new SolutionV1();
        int[] nums = {1, 2, 3};
        List<List<Integer>> results = solution.subsets(nums);
        results.forEach(System.out::println);

    }

    private final List<List<Integer>> results = new ArrayList<>(); // 存放符合条件结果的集合
    private final LinkedList<Integer> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0);
        return results;
    }

    private void subsets(int[] nums, int startIndex) {

        results.add(new LinkedList<>(result));

        // 表示剩余集合为空
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            result.addLast(nums[i]);
            subsets(nums, i + 1);
            result.removeLast();
        }
    }
}
