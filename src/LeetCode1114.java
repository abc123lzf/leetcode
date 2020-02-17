import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.18 0:56
 */
public class LeetCode1114 {

    private Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();

    private volatile int time = 3;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (time % 3 != 0) {
                condition.await();
            }
            printFirst.run();
            time++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while(time % 3 != 1) {
                condition.await();
            }
            printSecond.run();
            time++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (time % 3 != 2) {
                condition.await();
            }
            printThird.run();
            time++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
