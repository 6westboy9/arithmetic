package com.westboy;

/**
 * @author westboy
 * @since 2020/1/15
 */
public class Solution0004 {

	public static void main(String[] args) {
		int[] arr = {13, 41, 67, 26, 55, 99, 2, 82, 39, 100};
		System.out.println(getMaxGap(arr));
		// System.out.println(5/2);
	}

	public static int getMaxGap(int[] arr) {
		if (arr == null || arr.length < 2) {
			return -1;
		}

		int length = arr.length;

		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;

		// 找出最大最小值
		for (int i : arr) {
			maxValue = Math.max(maxValue, i);
			minValue = Math.min(minValue, i);
		}

		// 初始化每个桶的数据
		int[] maxs = new int[length + 1];
		int[] mins = new int[length + 1];
		boolean[] hasNum = new boolean[length + 1];

		for (int i : arr) {
			// 如果桶里没数，则该数入桶后，最大最小值都是它，否则更新最大最小值
			int bid = getBucketId(i, length + 1, minValue, maxValue);
			mins[bid] = !hasNum[bid] ? i : Math.min(i, mins[bid]);
			maxs[bid] = !hasNum[bid] ? i : Math.max(i, maxs[bid]);
			hasNum[bid] = true;
		}

		// 在两个相邻非空桶中查找相邻两个数的最大差值
		int res = 0;
		for (int i = 0; i < length; i++) {
			// 非空桶跳过
			if (hasNum[i]) {
				int j = i + 1;
				while (!hasNum[j]) {
					j++;
				}
				res = Math.max(res, (mins[j] - maxs[i]));
			}
		}

		return res;
	}

	/**
	 * 根据要入桶的数和最大最小值得到对应桶编号
	 *
	 * @param num        要入桶的数
	 * @param bucketsNum 桶的数目
	 * @param min        最小数
	 * @param max        最大数
	 * @return 要入桶的数和最大最小值得到对应桶编号
	 */
	private static int getBucketId(int num, int bucketsNum, int min, int max) {
		int i = (max - min + 1) / bucketsNum;
		return (num - min) / i;
	}

}
