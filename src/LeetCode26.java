/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 23:17
 */
public class LeetCode26 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0, j = 0;
        while (i < len && j < len) {
            int n = nums[j];
            while (j < len) {
                if(n == nums[j]) {
                    j++;
                } else {
                    break;
                }
            }

            nums[i] = n;
            i++;
        }

        return i;
    }

}
