/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.27 17:00
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return false;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        int start = len % 2 == 0 ? len / 2 : len / 2 + 1;
        node = head;
        int index = 1;
        while (index < start) {
            index++;
            node = node.next;
        }

        ListNode prev = node, next = node.next;
        prev.next = null;
        while (next != null) {
            ListNode t = next.next;
            next.next = prev;

            prev = next;
            next = t;
        }

        while (head != null && prev != null) {
            if(head.val != prev.val) {
                return false;
            }

            head = head.next;
            prev = prev.next;
        }


        return true;
    }

}
