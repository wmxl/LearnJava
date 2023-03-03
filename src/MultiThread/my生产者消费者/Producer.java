package MultiThread.my生产者消费者;

import java.util.LinkedList;

public class Producer extends Thread{
    Storage storage;
    int num;
    public Producer(Storage storage, int num) {
        this.storage = storage;
        this.num = num;
    }

    public void produce(int num){
        storage.produce(num);
    }

    @Override
    public void run() {
        produce(num);
    }
}
