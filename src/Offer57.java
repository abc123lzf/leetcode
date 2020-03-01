import java.util.ArrayList;
import java.util.List;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 17:43
 */
public class Offer57 {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        int len;
        for (len = 1; sum < target ; len++) {
            sum += len;
        }

        int[] arr = new int[len + 1];
        sum = 0;
        for (int i = 0; i < len + 1; i++) {
            arr[i] = sum;
            sum += i + 1;
        }

        len++;

        int l = 0, r = len - 1;
        while (l < r) {
            int s = arr[r] - arr[l];
            if(s == target) {
                int[] t = new int[r - l];
                for (int i = l + 1; i < r; i++) {
                    t[i] = i;
                }
                result.add(t);
                r--;
                l++;
            } else if(s < target) {
                r--;
            } else {
                l++;
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

}
