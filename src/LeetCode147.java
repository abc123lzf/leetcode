/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.20 3:21
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode now = head;
        ListNode prev = tmpHead;
        while (now != null) {
            ListNode cmp = now.next;
            ListNode t = null;
            while (cmp != null) {
                if(cmp.val < now.val) {
                    t = cmp.next;
                    break;
                }
                cmp = cmp.next;
            }

            if(t != null) {
                ListNode x = now.next;
                prev.next = x;
                prev = x;
                now = x;

                cmp.next = now;
                now.next = t;
            } else {
                break;
            }
        }

        return tmpHead.next;
    }

}
