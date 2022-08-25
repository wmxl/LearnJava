package MultiThread.生产者消费者;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Producer p = new Producer(person);
        Consumer c = new Consumer(person);
//        p.start();
    }
}
