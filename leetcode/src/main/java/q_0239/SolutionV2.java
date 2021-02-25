package q_0239;

import java.util.*;

/**
 * 滑动窗口最大值
 *
 * @author pengbo.wang
 * @date 2020/07/13 7:39 下午
 */
public class SolutionV2 {
    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        int[] nums = {2, 3, -1, 6, 6, 3, 2, 5};

        // 给你一个整数数组 nums，有一个大小 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
        // [2 3 -1] 6 6 3 2 5    3
        // 2 [3 -1 6] 6 3 2 5    6
        // 2 3 [-1 6 6] 3 2 5    6
        // 2 3 -1 [6 6 3] 2 5    6
        // 2 3 -1 6 [6 3 2] 5    6
        // 2 3 -1 6 6 [3 2 5]    5

        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));

    }

    /**
     * 方法拉夸，超出时间限制
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        MQueue queue = new MQueue(k, res.length);
        for (int num : nums) {
            queue.add(num);
        }

        return queue.getRes();
    }

    static class MQueue {
        private final LinkedList<Integer> queue;
        private final PriorityQueue<Integer> priorityQueue;
        private final int capacity;
        private final int[] res;
        private int resIdx;

        public MQueue(int capacity, int resLength) {
            this.queue = new LinkedList<>();
            this.priorityQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);
            this.capacity = capacity;
            this.res = new int[resLength];
            this.resIdx = 0;
        }

        public void add(int val) {
            queue.addLast(val);
            if (queue.size() == capacity) {
                priorityQueue.clear();
                priorityQueue.addAll(queue);
                res[resIdx++] = priorityQueue.peek();
                // System.out.println(queue);
                // System.out.println(priorityQueue);
                // System.out.println("--------------------");
                queue.removeFirst();
            }
        }

        public int[] getRes() {
            return res;
        }
    }

}


