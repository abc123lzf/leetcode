import java.util.HashMap;
import java.util.Map;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.25 20:03
 */
public class LeetCode1339 {
    private final Map<TreeNode, Integer> sumMap = new HashMap<>();
    private long result = 0L;

    public int maxProduct(TreeNode root) {
        dfs(root);
        solve(root, 0);
        return (int)(result % (1000000000 + 7));
    }

    private int dfs(TreeNode root) {
        int s = root.val;
        if(root.left != null) {
            s += dfs(root.left);
        }

        if(root.right != null) {
            s += dfs(root.right);
        }
        sumMap.put(root, s);
        return s;
    }

    private void solve(TreeNode root, int sum) {
        int ths = sum + sumMap.get(root);
        if(root.left != null) {
            int l = sumMap.get(root.left);
            result = Math.max((long)(ths - l) * (long)l, result);

            if(root.right == null) {
                solve(root.left, sum + root.val);
            } else {
                solve(root.left, sum + root.val + sumMap.get(root.right));
            }
        }

        if(root.right != null) {
            int r = sumMap.get(root.right);
            result = Math.max((long)(ths - r) * (long)r, result);

            if(root.left == null) {
                solve(root.right, sum + root.val);
            } else {
                solve(root.left, sum + root.val + sumMap.get(root.left));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1339().maxProduct(TreeBuilder.createTree("1,2,3,4,5,6")));
    }
}
