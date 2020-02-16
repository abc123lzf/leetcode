/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 23:52
 */
public class ListNodeBuilder {

    public static ListNode build(int... number) {
        ListNode head = new ListNode(number[0]);
        ListNode next = head;
        for(int i = 1; i < number.length; i++) {
            next.next = new ListNode(number[i]);
            next = next.next;
        }

        return head;
    }

    public static void print(ListNode printer) {
        int limit = 1000;
        int cnt = 0;
        while (printer != null && cnt < limit) {
            System.out.print(printer.val);
            System.out.print(' ');
            printer = printer.next;
            cnt++;
        }
    }

}
