/**
 * @author lizifan 695199262@qq.com
 * @since 2020.3.3 3:19
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode p0 = head;
        ListNode p1 = head;

        do {
            p0 = p0.next;
            if(p1 == null || p1.next == null) {
                return null;
            }
            p1 = p1.next.next;
        } while (p0 != p1);

        p1 = head;
        while (p0 != p1) {
            p0 = p0.next;
            p1 = p1.next;
        }

        return p0;
    }

}
