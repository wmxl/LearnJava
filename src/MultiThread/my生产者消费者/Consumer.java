package MultiThread.my生产者消费者;

import java.util.LinkedList;

public class Consumer extends Thread {
    Storage storage;
    int num;
    public Consumer(Storage storage, int num) {
        this.storage = storage;
        this.num = num;
    }

    public void consume(int n){
        storage.consume(n);
    }

    @Override
    public void run() {
        consume(num);
    }
}
