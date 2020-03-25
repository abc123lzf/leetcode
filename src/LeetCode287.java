/**
 * @author lizifan 695199262@qq.com
 * @since 2020.3.3 3:28
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);

        fast = 0;
        while (nums[slow] != nums[fast]) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return nums[slow];
    }
}
