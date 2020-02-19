import java.util.Stack;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.19 15:37
 */
public class LeetCode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> l1stack = new Stack<>();
        Stack<ListNode> l2stack = new Stack<>();

        while (l1 != null) {
            l1stack.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            l2stack.push(l2);
            l2 = l2.next;
        }

        ListNode head = null;
        int last = 0;
        while (true) {
            boolean l1empty = l1stack.empty();
            boolean l2empty = l2stack.empty();
            if(l1empty && l2empty) {
                break;
            }

            int val;
            if(l1empty) {
                val = l2stack.pop().val;
            } else if(l2empty) {
                val = l1stack.pop().val;
            } else {
                val = l1stack.pop().val;
                val += l2stack.pop().val;
            }

            if(last != 0) {
                val += last;
                last = 0;
            }

            if(val / 10 >= 1) {
                last = val / 10;
            }

            ListNode node = new ListNode(val % 10);
            if(head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        if(last != 0) {
            ListNode node = new ListNode(last);
            node.next = head;
            head = node;
        }

        return head;
    }

}
