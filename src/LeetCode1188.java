import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.17 1:06
 */
public class LeetCode1188 {

    private static boolean checkValue( int num )
    {
        int d1,d2,d3;
        int checkNum, nRemain, rem;

        checkNum = num % 10;
        nRemain = num /10;
        d3 = nRemain % 10;
        nRemain /= 10;
        d2 = nRemain % 10;
        nRemain /= 10;
        d1 = nRemain % 10;
        rem = (d1 + d2 + d3) % 7;
        return rem == checkNum;
    }
    public static void main(String[] args) throws InterruptedException{
        System.out.print(checkValue(8300));
    }
}

class BoundedBlockingQueue {

    private final int sizeLimit;
    private final AtomicInteger count = new AtomicInteger(0);

    private volatile Node head;
    private volatile Node tail;

    private final Lock pollLock = new ReentrantLock();
    private final Condition notEmpty = pollLock.newCondition();

    private final Lock offerLock = new ReentrantLock();
    private final Condition notFull = offerLock.newCondition();


    public BoundedBlockingQueue(int capacity) {
        this.sizeLimit = capacity;
        this.head = this.tail = new Node();
    }

    public void enqueue(int element) throws InterruptedException {
        Node n = new Node();
        n.val = element;

        offerLock.lock();
        try {
            if(count.get() > sizeLimit) {
                notEmpty.await();
            }

            tail.next = n;
            tail = n;
            count.incrementAndGet();
            notEmpty.signal();
        } finally {
            offerLock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        int val;
        pollLock.lock();
        try {
            if(count.get() == 0) {
                pollLock.wait();
            }

            Node n = head.next;
            head.next = n.next;

            count.decrementAndGet();
            val = n.val;
            notFull.signal();
        } finally {
            pollLock.unlock();
        }

        return val;
    }

    public int size() {
        return count.get();
    }

    static class Node {
        Node next;
        int val;
    }

}