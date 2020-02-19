import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 0:35
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if(nums[i] > 0) {
                break;
            }

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if(s == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (r > l && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                } else if(s > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return list;
    }

}
