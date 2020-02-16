import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author lizifan lzf@webull.com
 * @since 2019.11.12 8:21
 */
class ListNode implements Iterable<Integer> {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] nums) {
        ListNode target = new ListNode(nums[0]);
        ListNode head = target;
        for (int i = 1; i < nums.length; i++) {
            target.next = new ListNode(nums[i]);
            target = target.next;
        }
        this.val = head.val;
        this.next = head.next;
    }

    private class CommonIterator implements Iterator<Integer> {
        private ListNode next;

        CommonIterator() {
            this.next = ListNode.this;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Integer next() {
            ListNode t = next;
            next = next.next;
            return t.val;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CommonIterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        ListNode h = this;
        while (h != null) {
            action.accept(h.val);
            h = h.next;
        }
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return null;
    }

    public static boolean compareTwoListNode(ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) return false;
        while (node1 != null) {
            if (node2 ==null || node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

}
