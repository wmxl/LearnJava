package MultiThread.创建线程的三种方式;

public class FirstThreadTest extends Thread {
    int i = 0;

    //重写run方法，run方法的方法体就是线程执行体
    public void run() {
        for (; i < 30; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName() + "  : " + i);
            if (i == 20) {
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }
    }
}