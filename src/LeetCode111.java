/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 16:55
 */
public class LeetCode111 {

    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = dfs(root.left, 2);
        int r = dfs(root.right, 2);

        if(l == 1) {
            return r;
        } else if(r == 1) {
            return l;
        }

        return Math.min(l, r);
    }

    private static int dfs(TreeNode node, int deep) {
        if(node == null) {
            return deep - 1;
        }

        if(node.left == null && node.right == null) {
            return deep;
        }

        int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        if(node.left != null) {
            r = dfs(node.right, deep + 1);
        }

        if(node.right != null) {
            l = dfs(node.left, deep + 1);
        }

        return Math.min(l, r);
    }

    public static void main(String[] args) {
        minDepth(TreeBuilder.createTree("0,2,4,1,#,3,-1,5,1,#,6,#,8"));
    }

}
