package MultiThread.循环打印;

class TestThread implements Runnable {
    int i = 1;
    @Override
    public void run() {
            /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                while (i <= 100) {
                    notify();
                    System.out.println(Thread.currentThread().getName() + ":" + i);
//                    if(Thread.currentThread().getName().equals("线程1"))
//                        System.out.println(Thread.currentThread().getName() + ":" + 1);
//                    else
//                        System.out.println(Thread.currentThread().getName() + ":" + 2);
                    i++;
                    try {
                        /*放弃资源，等待*/
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    public static void main(String[] args) {
        /*只有一个TestThread对象*/
        TestThread t = new TestThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}