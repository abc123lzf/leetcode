import java.util.HashMap;
import java.util.Map;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 20:11
 */
public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len * 2);

        for (int i = 0; i < len; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            Integer index = map.get(nums[i]);
            if(index != null && index != i) {
                return new int[] {i, index};
            }
        }

        return new int[] {};
    }

}
