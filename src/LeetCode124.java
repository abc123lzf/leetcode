/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 16:29
 */
public class LeetCode124 implements Important {

    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        this.result = Math.max(this.result, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
