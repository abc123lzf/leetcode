/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.25 21:20
 */
public class LeetCodeSortedMergeIcci {

    public void merge(int[] nums1, int sum1, int[] nums2, int sum2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return;
        }

        int k = nums1.length - 1;
        int i = sum1 - 1;
        int j = sum2 - 1;

        while (k >= 0) {
            if(i < 0) {
                while (k >= 0) {
                    nums1[k] = nums1[j];
                    k--;
                    j--;
                }
                break;
            } else if(j < 0) {
                while (k >= 0) {
                    nums1[k] = nums2[i];
                    k--;
                    i--;
                }
                break;
            }

            int n1 = nums1[i];
            int n2 = nums2[j];
            if(n1 < n2) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else if(n1 > n2) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }



}
