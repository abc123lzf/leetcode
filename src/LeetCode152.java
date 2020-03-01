/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 18:29
 */
public class LeetCode152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmax = 1;
        int tmin = 1;

        for (int n : nums) {
            if(n < 0) {
                int t = tmax;
                tmax = tmin;
                tmin = t;
            }

            tmax = Math.max(n, tmax * n);
            tmin = Math.min(n, tmin * n);
            max = Math.max(tmax, tmin);
        }

        return max;
    }

}
