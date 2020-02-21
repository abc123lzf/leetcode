/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 1:53
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) +
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) / 2.0;
    }

    private int getKth(int[] nums1, int st1, int ed1,
                       int[] nums2, int st2, int ed2, int k) {
        int len1 = ed1 - st1 + 1;
        int len2 = ed2 - st2 + 1;
        if (len1 > len2) {
            return getKth(nums2, st2, ed2, nums1, st1, ed1, k);
        }

        if (len1 == 0) {
            return nums2[st2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[st1], nums2[st2]);
        }

        int i = st1 + Math.min(len1, k / 2) - 1;
        int j = st2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, st1, ed1, nums2, j + 1, ed2, k - (j - st2 + 1));
        } else {
            return getKth(nums1, i + 1, ed1, nums2, st2, ed2, k - (i - st1 + 1));
        }
    }



}
