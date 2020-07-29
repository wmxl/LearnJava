package MultiThread.ReentrantLock.顺序执行线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Service {

    // 通过nextThread控制下一个执行的线程
    private static int nextThread = 1;
    private ReentrantLock lock = new ReentrantLock();
    // 有三个线程，所有注册三个Condition
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void excuteA() {
        try {
            lock.lock();
            while (nextThread != 1) {
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void excuteB() {
        try {
            lock.lock();
            while (nextThread != 2) {
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void excuteC() {
        try {
            lock.lock();
            while (nextThread != 3) {
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + " 工作");
            nextThread = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 线程按顺序执行
 *
 * @author tangj
 *
 */
public class Application {

    private static Runnable getThreadA(final Service service) {
        return new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    service.excuteA();
                }
            }
        };
    }

    private static Runnable getThreadB(final Service service) {
        return new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    service.excuteB();
                }
            }
        };
    }

    private static Runnable getThreadC(final Service service) {
        return new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    service.excuteC();
                }
            }
        };
    }

    public static void main(String[] args) {
        Service service = new Service();
        Runnable A = getThreadA(service);
        Runnable B = getThreadB(service);
        Runnable C = getThreadC(service);

        new Thread(B, "B").start();
        new Thread(A, "A").start();
        new Thread(C, "C").start();
    }

}