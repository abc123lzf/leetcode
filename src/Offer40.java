import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 4:26
 */
public class Offer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(e -> -e));
        for (int i = 0; i < arr.length; i++) {
            if(queue.size() < k) {
                queue.offer(arr[i]);
            } else if(queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] result = new int[queue.size()];
        for (int i = queue.size() - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }

        return result;
    }

}
