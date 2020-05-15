import java.util.Arrays;

/**
 * @author westboy
 * @since 2020/1/3
 */
public class Solution0075 {
	public static void main(String[] args) {
		int[] colors = {2, 0, 2, 1, 1, 0};
		sortColors(colors);
		System.out.println(Arrays.toString(colors));
	}

	public static void sortColors(int[] nums) {
		int less = -1;
		int more = nums.length;
		int current = 0;
		int target = 1;
		while (current < more) {
			if (nums[current] < target) {
				swap(nums, current++, ++less);
			} else if (nums[current] > target) {
				swap(nums, current, --more);
			} else {
				current++;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
