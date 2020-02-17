/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 21:43
 */
public class LeetCode101 {

    public ListNode getIntersectionNode(ListNode ah, ListNode bh) {
        ListNode pa = ah;
        ListNode pb = bh;

        while (pa != pb) {
            pa = pa != null ? pa.next : bh;
            pb = pb != null ? pb.next : ah;
        }

        return pa;
    }
}
