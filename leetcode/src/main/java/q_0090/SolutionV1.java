package q_0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 *
 * @author pengbo
 * @since 2021/2/25
 */
public class SolutionV1 {

    public static void main(String[] args) {

        // 输入：nums = [1,2,2]
        // 输出：[[],[1],[2],[1,2],[1,2,2],[2,2]]

        // 输入：nums = [0]
        // 输出：[[],[0]]
        SolutionV1 solution = new SolutionV1();
        int[] nums = {1, 2, 2};
        List<List<Integer>> results = solution.subsetsWithDup(nums);
        results.forEach(System.out::println);

    }

    private final List<List<Integer>> results = new ArrayList<>();
    private final LinkedList<Integer> result = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums); // 需要要排序
        subsetsWithDup(nums, 0, used);
        return results;
    }

    private void subsetsWithDup(int[] nums, int startIndex, boolean[] used) {
        results.add(new LinkedList<>(result));

        // 表示剩余集合为空
        if (startIndex == nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            // 同一树层上重复元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            result.addLast(nums[i]);
            used[i] = true;
            subsetsWithDup(nums, i + 1, used);
            used[i] = false;
            result.removeLast();
        }
    }
}
