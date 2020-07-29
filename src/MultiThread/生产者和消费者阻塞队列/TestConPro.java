package MultiThread.生产者和消费者阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者模式
 * 使用阻塞队列BlockingQueue
 *
 * @author wanggenshen
 */

//成产者
class Producer implements Runnable {

    private final BlockingQueue blockingQueue;
    //设置队列缓存的大小。生产过程中超过这个大小就暂时停止生产

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    int task = 1;
    @Override
    public void run() {
        int count = 20;
        while (count-- > 0) {
            try {
                System.out.println("正在生产：" + task);
                //将生产出来的产品放在队列缓存中
                blockingQueue.put(task);
                ++task;
                //让其停止一会，便于查看效果
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer implements Runnable {

    private final BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        //只要阻塞队列中有任务，就一直去消费
        while (true) {

            try {
                System.out.println("正在消费： " + blockingQueue.take());
                //让其停止一会，便于查看效果
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestConPro {

    public static void main(String[] args) {
        final int QUEUE_SIZE = 2;

        BlockingQueue blockingQueue = new LinkedBlockingQueue(QUEUE_SIZE);

        Producer p = new Producer(blockingQueue);
        Consumer c = new Consumer(blockingQueue);

        new Thread(p).start();

        new Thread(c).start();
    }


}