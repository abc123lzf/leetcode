/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.20 3:12
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode prev = tmpHead;
        ListNode ths = head;

        while (ths != null) {
            if(ths.val == val) {
                ListNode t = ths.next;
                prev.next = t;
                ths = t;
            } else {
                prev = prev.next;
                ths = ths.next;
            }
        }

        return tmpHead.next;
    }

}
