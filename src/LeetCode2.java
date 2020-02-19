import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 3:00
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> l1q = new ArrayDeque<>(50);
        Queue<ListNode> l2q = new ArrayDeque<>(50);

        while (l1 != null) {
            l1q.offer(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2q.offer(l2);
            l2 = l2.next;
        }


        ListNode head = null;
        ListNode next = null;
        boolean l1empty;
        boolean l2empty;
        int last = 0;

        while (true) {
            l1empty = l1q.isEmpty();
            l2empty = l2q.isEmpty();
            if(l1empty && l2empty) {
                break;
            }

            ListNode a = null, b = null;
            int val = last;
            if(!l1empty) {
                val += l1q.poll().val;
            }

            if(!l2empty) {
                val += l2q.poll().val;
            }

            if(val > 10) {
                last = val / 10;
                val = val % 10;
            } else {
                last = 0;
            }

            if(head == null) {
                head = new ListNode(val);
                next = head;
            } else {
                next.next = new ListNode(val);
                next = next.next;
            }
        }

        if(last > 0) {
            next.next = new ListNode(last);
        }


        return head;
    }

    private void dfs(ListNode h) {

    }

}
