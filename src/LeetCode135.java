import java.util.Arrays;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 0:12
 */
public class LeetCode135 {
    public int candy(int[] arr) {
        int candy = 1;
        int sum = 0;
        int len = arr.length;
        int[] cache = new int[len];
        Arrays.fill(cache, 1);

        for (int i = 0; i < len - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                cache[i + 1]++;
            } else if(arr[i] > arr[i + 1]) {
                cache[i]++;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if(arr[i] > arr[i - 1] && cache[i] < cache[i - 1]) {
                cache[i] = cache[i + 1] + 1;
            }
        }


        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
