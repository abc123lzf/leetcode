/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 4:05
 */
public class LeetCode663 {

    private boolean result = false;

    public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root);
        if(sum % 2 != 0) {
            return false;
        }
        solve(root, sum / 2);
        return result;
    }


    private int solve(TreeNode root, int target) {
        if(root == null) {
            return 0;
        }

        int val = solve(root.left, target) + solve(root.right, target) + root.val;
        if(val == target) {
            result = true;
            return val;
        }

        return val;
    }

    private int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return sum(root.left) + sum(root.right) + root.val;
    }

}
