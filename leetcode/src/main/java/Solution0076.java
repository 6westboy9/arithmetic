import java.util.*;

/**
 * @author westboy
 * @since 2020/1/4
 */
public class Solution0076 {

	public static void main(String[] args) {
		int[][] intervals = {{8, 10}, {2, 6}, {1, 3}, {7, 12}, {13, 14}, {15, 18}};
		print(intervals);
		System.out.println();
		int[][] merged = mergeV2(intervals);

		// for (int[] ints : merged) {
		// 	System.out.println(Arrays.toString(ints));
		// }

	}

	private static List<Interval> wrapper(int[][] intervals) {
		List<Interval> intervalList = new LinkedList<>();
		for (int[] ints : intervals) {
			Interval interval = new Interval();
			interval.start = ints[0];
			interval.end = ints[1];
			intervalList.add(interval);
		}
		return intervalList;
	}

	private static int[][] unWrapper(List<Interval> mergedList) {
		int[][] merged = new int[mergedList.size()][2];
		for (int i = 0; i < mergedList.size(); i++) {
			Interval interval = mergedList.get(i);
			merged[i][0] = interval.start;
			merged[i][1] = interval.end;
		}
		return merged;
	}

	private static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			return Integer.compare(a.start, b.start);
		}
	}

	public static int[][] mergeV1(int[][] intervals) {
		List<Interval> intervalList = wrapper(intervals);
		intervalList.sort(new IntervalComparator());

		LinkedList<Interval> merged = new LinkedList<>();
		for (Interval interval : intervalList) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			} else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}

		return unWrapper(merged);
	}


	static class Interval {
		private int start;
		private int end;

		@Override
		public String toString() {
			return "{" + "start=" + start + ", end=" + end + '}';
		}
	}


	// 方法二，贼屌
	public static int[][] mergeV2(int[][] intervals) {
		int len = intervals.length;
		int mergeCount = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (mergeV2(intervals, i, j)) {
					mergeCount++;
					break;
				}
			}
			print(intervals);
			System.out.println();
		}

		int[][] res = new int[len - mergeCount][2];



		int index = 0;
		for (int[] interval : intervals) {
			if (interval[0] == 1 && interval[1] == -1) {
				continue;
			}
			res[index][0] = interval[0];
			res[index][1] = interval[1];
			index++;
		}
		return res;

	}

	private static void print(int[][] intervals) {
		for (int[] interval : intervals) {
			System.out.print(Arrays.toString(interval));
		}
	}

	public static boolean mergeV2(int[][] intervals, int i, int j) {
		// 根据调用处传参，j 恒大于 i，所以此处的判断是不必的
		// if (j <= i) {
		// 	return false;
		// }

		// j > i

		// 这块其实也是不需要判断的，因为每次循环结束后，会将合并的后的区间放置在后面，被合并的区间会置为 [1, -1]
		// 每次循环 i++，所以被合并的 [1, -1] 只能在 i++ 之前，即不会出现 intervals[i][1] == -1 && intervals[i][0] == 1 的情况
		// if (intervals[i][1] == -1 && intervals[i][0] == 1) {
		// 	return false;
		// }

		// 这里就更不需要判断了，因为 j > i 的，根据合并规则，后面的区间肯定不会为 [1, -1]
		// if (intervals[j][1] == -1 && intervals[j][0] == 1) {
		// 	return false;
		// }
		if (intervals[i][0] < intervals[j][0] && intervals[i][1] < intervals[j][0]) {
			return false;
		}

		if (intervals[j][0] < intervals[i][0] && intervals[j][1] < intervals[i][0]) {
			return false;
		}

		int left = Math.min(intervals[i][0], intervals[j][0]);
		int right = Math.max(intervals[i][1], intervals[j][1]);
		intervals[j][0] = left;
		intervals[j][1] = right;
		intervals[i][0] = 1;
		intervals[i][1] = -1;
		return true;
	}

}


