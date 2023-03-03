package MultiThread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class FirstReentrantLock {

    public static void main(String[] args) {
        Runnable runnable = new ReentrantLockThread();
        new Thread(runnable, "a").start();
        new Thread(runnable, "b").start();
    }

}

class ReentrantLockThread implements Runnable {
    // 创建一个ReentrantLock对象
    ReentrantLock lock = new ReentrantLock();
    ReentrantLock fairLock  =new ReentrantLock(true);//传true是一个公平锁，不传默认是非公平锁
    @Override
    public void run() {
        try {
            // 使用lock()方法加锁，锁住的是从lock.lock()至lock.unlock()之间的代码
            lock.lock();
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "输出了：  " + i);
            }
        } finally {
            // 别忘了执行unlock()方法释放锁
            lock.unlock();
        }
    }

}