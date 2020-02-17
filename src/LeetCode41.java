/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 22:19
 */
public class LeetCode41 {

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 1;
        }

        for (int i = 1; i <= len; i++) {
            int idx = i % len;

            while (inArea(nums, idx) && nums[idx] != i && nums[idx] != nums[nums[idx] % len]) {
                swap(nums, idx, nums[idx]);
            }
        }

        for (int i = 1; i <= len; i++) {
            if (nums[i % len] != i) {
                return i;
            }
        }
        return len + 1;
    }

    private static void swap(int[] number, int i, int j) {
        int len = number.length;
        int t = number[i % len];
        number[i % len] = number[j % len];
        number[j % len] = t;
    }

    private static boolean inArea(int[] nums, int idx) {
        return nums[idx] >= 1 && nums[idx] <= nums.length;
    }


    public static void main(String[] args) {
        int v = firstMissingPositive(new int[]{1, 4, 2, 0, 3, 4, 2, 4, 2});
        System.out.print(v);
    }
}
