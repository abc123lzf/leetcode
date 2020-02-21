import java.io.IOException;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 18:01
 */
public class LeetCode114 {
    public static void flatten(TreeNode root) {
        dfs(root);
    }

    private static TreeNode dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root;
        }

        if(root.left == null) {
            return dfs(root.right);
        } else if(root.right == null) {
            TreeNode tl = root.left;
            TreeNode t = dfs(root.left);
            root.left = null;
            root.right = tl;
            return t;
        } else {
            TreeNode tr = root.right;
            TreeNode tl = root.left;
            TreeNode l = dfs(root.left);
            TreeNode r = dfs(root.right);
            root.left = null;
            root.right = tl;
            l.right = tr;
            return r;
        }
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = TreeBuilder.createTree("1,2,5,3,4,#,6");
        flatten(root);
        System.in.read();
    }
}
