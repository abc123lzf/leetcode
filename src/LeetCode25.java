/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 23:44
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }
        ListNode h = head;
        ListNode[] p = new ListNode[k + 2];
        ListNode returnNode = null;

        p[0] = null;
        loop:
        while (head != null) {
            for (int i = 1; i <= k; i++) {
                if(head == null) {
                    break loop;
                }
                p[i] = head;
                head = head.next;
            }

            if(returnNode == null) {
                returnNode = p[k];
            }

            p[k + 1] = head;

            for (int i = k; i >= 2; i--) {
                p[i].next = p[i - 1];
            }

            p[1].next = p[k + 1];

            if(p[0] != null) {
                p[0].next = p[k];
            }

            p[0] = p[1];
        }

        return returnNode != null ? returnNode : h;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeBuilder.build(1,2);
        ListNode returned = new LeetCode25().reverseKGroup(head, 1);
        ListNodeBuilder.print(returned);
    }

}
