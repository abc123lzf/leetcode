import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.3.16 16:55
 */
public class LeetCode1249 {

    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        Deque<Integer> deque = new ArrayDeque<>(len / 2);
        boolean[] vis = new boolean[len];

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                deque.offer(i);
            } else if(ch == ')') {
                if(deque.isEmpty()) {
                    vis[i] = true;
                } else {
                    deque.poll();
                }
            }
        }

        while (!deque.isEmpty()) {
            vis[deque.poll()] = true;
        }

        StringBuilder ans = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if(!vis[i]) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

}
