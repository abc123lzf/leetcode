/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 19:45
 */
public class LeetCode440 implements Important {

    private int targetIndex;
    private int maxIndex;
    private int maxDeep;
    private int ans = 0;

    static class Node {
        int left;
        int right;
        int lval;
        int rval;

        public Node(int left, int right, int lval, int rval) {
            this.left = left;
            this.right = right;
            this.lval = lval;
            this.rval = rval;
        }
    }

    public int findKthNumber(int n, int k) {
        targetIndex = k;
        maxIndex = n;

        int multi = (int)Math.pow(10, maxDeep = String.valueOf(n).length());
        for (int i = 1; i <= 9; i++) {
            int st = (i - 1) * multi + 1;
            int ed = i * multi;

            dfs(new Node(st, ed, i * 10, (i + 1) * 10), 2);
        }

        return 0;
    }


    private void dfs(Node root, int deep) {
        if(targetIndex < root.left && targetIndex > root.right) {
            return;
        }

        if(maxDeep == deep) {

        }

        int added = (int)Math.pow(10, deep - 1);
        for (int i = root.left; i <= 9; i += added) {
            dfs(new Node(i + 1, i * 10, i * pow10(deep), (i + 1) * pow10(deep)), deep + 1);
        }

    }

    private static int pow10(int x) {
        return (int)Math.pow(10, x);
    }


    public static void main(String[] args) {
        int v = new LeetCode440().findKthNumber(150, 10);
        System.out.print(v);
    }
}
