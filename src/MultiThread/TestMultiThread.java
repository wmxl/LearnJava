package MultiThread;

public class TestMultiThread {
    public static void main(String[] args) {
        new Thread(){
            public void run(){
                System.out.println("thread1 start ... ");
            }
        }.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 start .... ");
            }
        }).start();
    }
}
