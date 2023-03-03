package MultiThread.my生产者消费者;

import java.util.LinkedList;

public class Storage {
    int SIZE_MAX = 100;
    LinkedList list = new LinkedList();

    public void consume(int num) {
        synchronized (list) {

            while (num > list.size()) {
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行消费任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                list.remove();
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    public void produce(int num) {
        synchronized (list) {
            while (num + list.size() > SIZE_MAX) {
                System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }
}
