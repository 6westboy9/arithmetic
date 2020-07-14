package q_0239;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @author pengbo.wang
 * @date 2020/07/13 7:39 下午
 */
public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        int[] nums = {2, 3, -1, 6, 6, 3, 2, 5};

        // [2 3 -1] 6 6 3 2 5    3
        // 2 [3 -1 6] 6 3 2 5    6
        // 2 3 [-1 6 6] 3 2 5    6
        // 2 3 -1 [6 6 3] 2 5    6
        // 2 3 -1 6 [6 3 2] 5    6
        // 2 3 -1 6 6 [3 2 5]    5

        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int maxIdx = 0;

        for (int i = 0; i < k; i++) {
            cleanDeque(deque, nums, i, k);
            deque.addLast(i);
            maxIdx = nums[i] > nums[maxIdx] ? i : maxIdx;
        }

        // 存储结果集
        int[] result = new int[length - k + 1];
        result[0] = nums[maxIdx];

        for (int i = k; i < length; i++) {
            cleanDeque(deque, nums, i, k);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

    private void cleanDeque(ArrayDeque<Integer> deque, int[] nums, int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }

        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }
}
