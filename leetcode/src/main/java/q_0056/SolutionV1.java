package q_0056;

import cn.hutool.json.JSONUtil;

/**
 * @author pengbo
 * @since 2020/11/19
 */
public class SolutionV1 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };


        SolutionV1 solution = new SolutionV1();
        int[][] res = solution.merge(intervals);
        System.out.println(JSONUtil.toJsonStr(res));
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;

        // 合并次数
        int mergeCount = 0;

        // 步骤一：两层 for 循环对所有合并对象一一合并
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (merge(intervals, i, j)) {
                    mergeCount++;
                    break;
                }
            }
        }

        // len - mergeCount 表示合并后的数组个数，每个数组两个元素值
        int[][] res = new int[len - mergeCount][2];

        // 步骤二：排除特殊值后的结果
        int resIndex = 0; // resIndex 为 res 的数组下标
        for (int i = 0; i < len; i++) {
            if (intervals[i][0] == 1 && intervals[i][1] == -1) {
                continue;
            }
            res[resIndex][0] = intervals[i][0];
            res[resIndex][1] = intervals[i][1];
            resIndex++;
        }
        return res;

    }

    /**
     * 作用就是合并两个数组
     *
     * [1,3] [2, 4] -> [1,4] [1,-1]
     *
     */
    public boolean merge(int[][] intervals, int k, int j) {

        // 已经被合并的不予以考虑
        // if(intervals[k][1] == -1 && intervals[k][0] == 1) {
        //     return false;
        // }
        // if(intervals[j][1] == -1 && intervals[j][0] == 1) {
        //     return false;
        // }

        // [0, 1] [3, 5] 即 0 < 3 && 1 < 3 的情况
        // if (intervals[k][0] < intervals[j][0] && intervals[k][1] < intervals[j][0]) {
        //     return false;
        // }
        //
        // // [3, 5] [1, 2] 即 1 < 3 && 2 < 3 的情况
        // if (intervals[j][0] < intervals[k][0] && intervals[j][1] < intervals[k][0]) {
        //     return false;
        // }

        // intervals[k] 与 intervals[j] 两个数组元素值对比
        // intervals[k] 为外层循环数组
        // intervals[j] 为内存循环数组

        // intervals[k][0] intervals[k][1]
        // intervals[j][0] intervals[j][1]

        // [0, 1] [3, 5] 即 1 < 3 的情况
        if (intervals[k][1] < intervals[j][0]) {
            return false;
        }

        // [3, 5] [1, 2] 即 2 < 3 的情况
        if (intervals[j][1] < intervals[k][0]) {
            return false;
        }

        int left = Math.min(intervals[k][0], intervals[j][0]);
        int right = Math.max(intervals[k][1], intervals[j][1]);

        // 合并后的结果起来
        intervals[j][0] = left;
        intervals[j][1] = right;

        // 被合并的均设置为一个特殊值，用于区分
        intervals[k][0] = 1;
        intervals[k][1] = -1;
        return true;
    }
}
