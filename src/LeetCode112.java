/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 15:21
 */
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int sum, int target) {
        if(root == null) {
            return false;
        }

        sum += root.val;
        if(root.left == null && root.right == null) {
            return sum == target;
        }

        return dfs(root.right, sum, target) || dfs(root.left, sum, target);
    }
}
