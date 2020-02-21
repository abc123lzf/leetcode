import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 22:11
 */
public class Main {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            sum = (sum + min) % 1000000007;
            for (int j = i + 1; j < len; j++) {
                min = Math.min(arr[j], min);
                sum = (sum + min) % 1000000007;
            }
        }
        return sum;
    }
}
