import java.util.Arrays;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 22:41
 */
public class LeetCode11 {

    public int candy(int[] arr) {
        int candy = 1;
        int sum = 0;
        int len = arr.length;
        int[] cache = new int[len];
        Arrays.fill(cache, 1);

        for (int i = len - 2; i >= 0; i--) {
            if(arr[i] > arr[i + 1]) {
                cache[i] = cache[i + 1] + 1;
            }
        }

        for (int i = 1; i < len; i++) {
            if(arr[i] > arr[i - 1]) {
                cache[i] = Math.max(cache[i], cache[i - 1] + 1);
            }
        }


        for (int i = 0; i < len; i++) {
            sum += cache[i];
        }

        return sum;
    }

}
