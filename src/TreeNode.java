/**
 * @author lizifan lzf@webull.com
 * @since 2019.11.12 8:22
 */
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("[val:%d left:%d right:%d]",
                val,
                left != null ? left.val : null,
                right != null ? right.val : null);
    }
}
