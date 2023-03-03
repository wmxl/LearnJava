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
                for (int i = 1; i <= 9; i += 2) {
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
            for (int i = 2; i <= 10; i += 2) {
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

        t1.setPriority(Thread.MAX_PRIORITY);// 为什么设置了这个还是有时候会 Thread 2 在前面
        /**
         * 答：
         * 线程的优先级仍然无法保障线程的执行次序。只不过，优先级高的线程获取CPU资源的概率较大，优先级低的并非没机会执行。
         * 线程的优先级具有继承性，比如A线程启动B线程，则A和B的线程优先级是一样的。
         */
        System.out.println("Thread.MAX_PRIORITY = " + Thread.MAX_PRIORITY);
        t2.setPriority(3);
        t1.start();
        t2.start();
    }
}