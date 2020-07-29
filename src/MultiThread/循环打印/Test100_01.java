package MultiThread.循环打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by cjy
 * desc: lock and condition
 */
public class Test100_01 {

    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    public static void main(String[] args) {

        // thread 1
        Thread t1 = new Thread(new Runnable() {//匿名类写法
            @Override
            public void run() {
                for (int i = 1; i <= 999; i += 2) {
                    lock.lock();
                    try {
                        condition2.signal();
                        System.out.println("thread 1:" + i);
                        condition1.await();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }
        });

        // thread 2
        Thread t2 = new Thread(() -> {//lambda表达式写法
            for (int i = 2; i <= 1000; i += 2) {
                lock.lock();
                try {
                    condition1.signal();
                    System.out.println("thread 2:" + i);

                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();

            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}