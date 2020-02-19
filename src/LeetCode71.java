import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 3:19
 */
public class LeetCode71 {

    public String simplifyPath(String path) {
        String[] str = path.split("/");
        List<String> list = new LinkedList<>();
        Collections.addAll(list, str);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if(s.isEmpty()) {
                it.remove();
            } else if(s.equals(".")) {
                it.remove();
            }
        }

        Deque<String> deque = new ArrayDeque<>();
        for (String p : list) {
            if(p.equals("..")) {
                deque.pollLast();
            } else {
                deque.offerLast(p);
            }
        }

        if(deque.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        deque.forEach(e -> {
            ans.append("/").append(e);
        });


        return ans.toString();
    }

}
