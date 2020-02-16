/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 21:46
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = null;

        while (true) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            if(p3 == null) {
                break;
            }
            p2 = p3;
        }

        return p2;
    }

}
