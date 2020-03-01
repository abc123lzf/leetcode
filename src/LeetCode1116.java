import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.27 23:48
 */
public class LeetCode1116 {

    static class ZeroEvenOdd {
        private final int limit;
        private final Lock lock = new ReentrantLock(true);
        private final Condition condition = lock.newCondition();

        private final CountDownLatch ready = new CountDownLatch(1);

        private volatile int number = 1;
        private volatile int serial = 0;


        public ZeroEvenOdd(int limit) {
            this.limit = limit;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (true) {
                lock.lock();
                try {
                    if(ready.getCount() > 0) {
                        ready.countDown();
                    }

                    while (serial % 2 != 0 && number < limit) {
                        condition.await();
                    }

                    if(number >= limit) {
                        printNumber.accept(0);
                        condition.signalAll();
                        break;
                    }

                    printNumber.accept(0);
                    serial++;
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }


        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            ready.await();
            while (true) {
                lock.lock();
                try {
                    while ((serial % 2 == 0 || number % 2 == 1) && number < limit) {
                        condition.await();
                    }

                    if(number >= limit) {
                        break;
                    }

                    printNumber.accept(number);
                    number++;
                    serial++;

                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }

            if(limit % 2 == 0) {
                lock.lock();
                printNumber.accept(limit);
                lock.unlock();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            ready.await();
            while (true) {
                lock.lock();
                try {
                    while ((serial % 2 == 0 || number % 2 == 0) && number < limit) {
                        condition.await();
                    }

                    if(number >= limit) {
                        break;
                    }

                    printNumber.accept(number);
                    number++;
                    serial++;

                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }

            if(limit % 2 == 1) {
                lock.lock();
                printNumber.accept(limit);
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        ZeroEvenOdd task = new ZeroEvenOdd(4);
        IntConsumer consumer = System.out::println;
        new Thread(() -> {
            try {
                    task.zero(consumer);

            } catch (Exception ignore) {
            }
        }).start();

        new Thread(() -> {
            try {

                task.odd(consumer);

            } catch (Exception ignore) {
            }
        }).start();

        new Thread(() -> {
            try {

                    task.even(consumer);

            } catch (Exception ignore) {
            }
        }).start();

    }

}
