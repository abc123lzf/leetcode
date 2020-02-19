/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 21:28
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int st, int ed, int target) {
        if(st > ed) {
            return -1;
        }

        if(nums[st] == target) {
            return st;
        } else if(nums[ed] == target) {
            return ed;
        }

        while (st < ed && nums[st] == nums[st + 1]) {
            st++;
        }

        while (ed > st && nums[ed] == nums[ed - 1]) {
            ed--;
        }

        int mid = (st + ed) / 2;
        if(nums[mid] == target) {
            return mid;
        }


        if(nums[mid] > nums[st] && nums[ed] <= nums[st]) {
            if(target > nums[st] && target < nums[mid]) {
                return search(nums, st, mid - 1, target);
            } else {
                return search(nums, mid + 1, ed, target);
            }
        } else {
            if(target > nums[mid] && target < nums[ed]) {
                return search(nums, mid + 1, ed, target);
            } else {
                return search(nums, st, mid - 1, target);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode33().search(new int[]{1,2,3,4,5,6}, 4));
    }

}
