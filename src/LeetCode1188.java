import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 1:06
 */
public class LeetCode1188 {


}

class BoundedBlockingQueue {

    private final int sizeLimit;
    private final AtomicInteger count = new AtomicInteger(0);

    private final Node head;
    private volatile Node tail;

    private final Lock offerLock = new ReentrantLock();
    private final Condition notFull = offerLock.newCondition();

    private final Lock pollLock = new ReentrantLock();
    private final Condition notEmpty = pollLock.newCondition();

    private static final AtomicReferenceFieldUpdater<BoundedBlockingQueue, Node> TAIL =
            AtomicReferenceFieldUpdater.newUpdater(BoundedBlockingQueue.class, Node.class, "tail");

    private static final AtomicReferenceFieldUpdater<Node, Node> NEXT_UPD =
            AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");

    static class Node {
        volatile Node next;
        int val;

        Node(int val) {
            this.val = val;
        }

        Node() { }
    }

    public BoundedBlockingQueue(int capacity) {
        this.sizeLimit = capacity;
        this.head = this.tail = new Node();
    }

    public void enqueue(int element) throws InterruptedException {
        Node node = new Node(element);
        node.next = tail;

        LockSupport.park();
        if (count.get() > sizeLimit) {
            offerLock.lock();
            try {
                while (count.get() > sizeLimit) {
                    notFull.await();
                }
            } finally {
                offerLock.unlock();
            }
        }

        Node t;
        do {
            t = this.tail;
        } while (!TAIL.compareAndSet(this, t, node));

        t.next = node;
        count.incrementAndGet();

        pollLock.lock();
        try {
            notEmpty.signal();
        } finally {
            pollLock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        if (count.get() == 0) {
            pollLock.lock();
            try {
                while (count.get() == 0) {
                    notEmpty.await();
                }
            } finally {
                pollLock.unlock();
            }
        }

        Node res, t;
        do {
            res = head.next;
            t = res.next;
        } while (NEXT_UPD.compareAndSet(head, res, t));



        return res.val;
    }

    public int size() {
        return count.get();
    }

}