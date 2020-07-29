package MultiThread.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者线程
 *
 * @author tangj
 *
 */
class MyThreadProduce implements Runnable {

    private Service service;

    public MyThreadProduce(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {
            service.produce();
        }
    }
}

/**
 * 消费者线程
 *
 * @author tangj
 *
 */
class MyThreadConsume implements Runnable {

    private Service service;

    public MyThreadConsume(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {
            service.consume();
        }
    }

}
public class Service {

    private Lock lock = new ReentrantLock();
    private boolean flag = false; //如果开始是ture，就算 先消费 0 1 0 1 ……
    private Condition condition = lock.newCondition();
    // 以此为衡量标志
    private int number = 1;

    /**
     * 生产者生产
     */
    public void produce() {
        try {
            lock.lock();
            while (flag == true) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "-----生产-----");
            number++;
            System.out.println("number: " + number);
            System.out.println();
            flag = true;
            // 提醒消费者消费
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者消费生产的物品
     */
    public void consume() {
        try {
            lock.lock();
            while (flag == false) {
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "-----消费-----");
            number--;
            System.out.println("number: " + number);
            System.out.println();
            flag = false;
            // 提醒生产者生产
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        Runnable produce = new MyThreadProduce(service);
        Runnable consume = new MyThreadConsume(service);
        new Thread(produce, "生产者  ").start();
        new Thread(consume, "消费者  ").start();
    }
}