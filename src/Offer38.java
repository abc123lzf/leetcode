import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 4:32
 */
public class Offer38 {

    public String[] permutation(String s) {
        int len = s.length();
        int size = 1;
        for (int i = 1; i <= len; i++) {
            size *= i;
        }

        String[] result = new String[size];
        dfs(s, new char[s.length()], 0, new boolean[s.length()], result, new AtomicInteger(0));
        return result;
    }

    private void dfs(String source, char[] cache, int index, boolean[] vis, String[] result, AtomicInteger resultIndex) {
        if(index == cache.length) {
            result[resultIndex.get()] = new String(cache);
            resultIndex.incrementAndGet();
            return;
        }

        for (int i = 0; i < source.length(); i++) {
            if(!vis[i]) {
                cache[index] = source.charAt(i);
                vis[i] = true;
                dfs(source, cache, index + 1, vis, result, resultIndex);
                vis[i] = false;
            }

            while (i < source.length() - 1 && source.charAt(i) != source.charAt(i + 1)) {
                i++;
            }
        }
    }

}
