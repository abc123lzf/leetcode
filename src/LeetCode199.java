import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 23:25
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        Queue<TreeNode> floor = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();


        while (!queue.isEmpty()) {
            int val = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    floor.offer(node.left);
                if(node.right != null)
                    floor.offer(node.right);
                val = node.val;
            }

            result.add(val);

            while (!floor.isEmpty()) {
                queue.offer(floor.poll());
            }
        }

        return result;
    }

}
