/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.28 17:23
 */
public class Offer6 {
    public int[] reversePrint(ListNode head) {
        if(head == null) {
            return new int[0];
        } else if(head.next == null) {
            return new int[] {head.val};
        }


        ListNode prev = head;
        ListNode next = head.next;
        prev.next = null;

        int len = 1;

        while (next != null) {
            ListNode t = next.next;
            next.next = prev;

            prev = next;
            next = t;

            len++;
        }

        int[] result = new int[len];
        int index = 0;

        while (prev != null) {
            result[index++] = prev.val;
            prev = prev.next;
        }

        return result;
    }
}
