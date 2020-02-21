import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.21 19:50
 */
public class LeetCode155 {

    private final Deque<Integer> deque = new ArrayDeque<>();

    public void push(int x) {
        if(deque.isEmpty()) {
            deque.offerFirst(x);
            deque.offerFirst(x);
        } else {
            Integer val = deque.pollFirst();
            Integer min = deque.peek();
            assert val != null && min != null;
            deque.offerFirst(val);
            deque.offerFirst(Math.min(min, x));
            deque.offerFirst(x);
        }
    }

    public void pop() {
        deque.pollFirst();
        deque.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public int getMin() {
        Integer val = deque.pollFirst();
        Integer min = deque.peek();
        assert min != null && val != null;
        deque.offerFirst(val);
        return min;
    }

}
