package MultiThread;

class Sync{
    Object lock = new Object();

    public  void test(){
//        String obj = "";
        synchronized(lock){
//        synchronized(this){ 这两效果差不多
            System.out.println("test开始执行。。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test执行结束。。。");
        }
    }
    public  void test2(){
//        String obj = "";
        synchronized(lock){
            System.out.println("test开始执行。。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test执行结束。。。");
        }
    }
}

public class SynchronizeObject {
    public static void main(String[] args) {
        final Sync sync = new Sync();
        //线程1
        new Thread(new Runnable() {
            public void run() {
                sync.test();
            }
        }).start();
        //线程2
        new Thread(new Runnable() {
            public void run() {
                sync.test();
            }
        }).start();
//        //线程3
//        new Thread(new Runnable() {
//            public void run() {
//                sync.test();
//            }
//        }).start();
    }
}
