import java.util.ArrayList;
import java.util.List;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.27 16:43
 */
public class LeetCode386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private static void dfs(int ths, final int target, final List<Integer> list) {
        if(ths > target) {
            return;
        }

        list.add(ths);
        for (int i = 0; i < 10; i++) {
            dfs(ths * 10, target, list);
        }
    }

}
