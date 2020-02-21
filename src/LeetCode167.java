/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.22 3:00
 */
public class LeetCode167 {

    public int[] twoSum(int[] arr, int target) {
        int len = arr.length;
        int l = 0, r = len - 1;
        while (l < r) {
            int ln = arr[l];
            int rn = arr[r];

            if(ln + rn == target) {
                return new int[] {l + 1, r + 1};
            } else if(ln + rn < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[0];
    }

}
