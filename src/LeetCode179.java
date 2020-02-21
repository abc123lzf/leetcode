import java.util.Arrays;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 21:01
 */
public class LeetCode179 {

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            String s0 = a + b;
            String s1 = b + a;
            return s1.compareTo(s0);
        });

        if(arr[0].equals("0")) {
            return "0";
        }


        StringBuilder sb = new StringBuilder(50);
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

}
