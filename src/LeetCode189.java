/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 20:01
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k == 0) {
            return;
        }

        for (int i = 0, j = len - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }

        for (int i = 0, j = k - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }

        for (int i = k, j = len - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
