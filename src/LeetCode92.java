/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 0:58
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int min, int max) {
        if(head == null || head.next == null) {
            return head;
        }
        int index = 1;
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode first = null, last = null;
        ListNode tail = null;

        ListNode prev = tmpHead;
        ListNode now = head;
        while (now != null) {
            if(index == min) {
                first = prev;
            } else if (index > min && index <= max) {
                last = now;
                ListNode next = now.next;
                if(next != null) {
                    tail = next;
                } else {
                    tail = next;
                }
                now.next = prev;
                if(index == min + 1) {
                    prev.next = null;
                }

                prev = now;
                now = next;
                index++;
                continue;
            }

            prev = now;
            now = now.next;
            index++;
        }

        ListNode t = first.next;
        first.next = last;
        t.next = tail;

        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode n = new LeetCode92().reverseBetween(ListNodeBuilder.build(1,2,3,4,5), 2, 4);
    }

}
