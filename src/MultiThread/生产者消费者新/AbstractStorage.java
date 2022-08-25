package MultiThread.生产者消费者新;

public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
