import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.3.1 16:13
 */
public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(30);
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int ts = nums[i] + nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int s = ts + nums[l] + nums[r];
                    if(s == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if(s < target) {
                        l++;
                    } else {
                        r--;
                    }

                }
            }
        }

        return result.stream().distinct().collect(Collectors.toList());
    }

}
