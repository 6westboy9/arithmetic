package q_0239;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author pengbo.wang
 * @date 2020/07/13 7:39 下午
 */
public class SolutionV3 {
    public static void main(String[] args) {
        SolutionV3 solution = new SolutionV3();
        int[] nums = {2, 3, -1, 2, 1, 3, 2, 5};

        // 给你一个整数数组 nums，有一个大小 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。

        // i=0  {2, 3, -1, 2, 1, 3, 2, 5} queue={0}     queue.val={2}       {2}
        // i=1  {2, 3, -1, 2, 1, 3, 2, 5} queue={1}     queue.val={3}       {2, 3}
        // i=2  {2, 3, -1, 2, 1, 3, 2, 5} queue={1,2}   queue.val={3,-1}    {2, 3, -1}
        // i=3  {2, 3, -1, 2, 1, 3, 2, 5} queue={1,3}   queue.val={3,2}     {3, -1, 2}
        // i=4  {2, 3, -1, 2, 1, 3, 2, 5} queue={3,4}   queue.val={2,1}     {-1, 2, 1}

        // 参考题解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/yi-ge-shi-pin-kan-dong-shuang-duan-dui-l-tqqn/
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 3)));

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return null;
        }

        int[] res = new int[nums.length - k + 1];
        int resIdx = 0;

        // queue 存储的是数组元素下标
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            // queue 中存储的元素下标对应值的关系为递减，只要满足 nums[i] >= nums[queue.peekLast()] 条件，就要进行尾部弹出
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.addLast(i);

            // 发现此时队列头已经在窗口之外，就要进行头部弹出
            // 比如 i = 2，queue.peekFirst()=0，k=3，说明队列头还在窗口内
            // 比如 i = 3，queue.peekFirst()=0，k=3，说明队列头已经在窗口外（即满足 i - queue.peekFirst() == k 条件）
            if (!queue.isEmpty() && (i - queue.peekFirst() == k)) {
                queue.pollFirst();
            }

            // 遍历到 i 从第 k-1 个元素开始往后，就会有结果值
            if (i >= k - 1) {
                res[resIdx++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


}


