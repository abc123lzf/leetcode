/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 22:07
 */
public class LeetCode42 {

    public int trap(int[] height) {
        if(height.length <= 2) {
            return 0;
        }

        int width = height.length;
        int[] left = new int[width];

        left[0] = 0;
        for (int i = 1; i < width; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        int[] right = new int[width];

        right[width - 1] = 0;
        for (int i = width - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 1; i <= width - 2; i++) {
            int l = left[i];
            int r = right[i];

            int added = Math.min(l, r) - height[i];
            if(added > 0) {
                sum += added;
            }
        }

        return sum;
    }



}
