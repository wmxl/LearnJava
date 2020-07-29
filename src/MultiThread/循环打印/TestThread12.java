package MultiThread.循环打印;

class TestThread12 implements Runnable {
    int i = 1;
    @Override
    public void run() {
        while (true) {
            /*指代的为TestThread,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                if (i <= 5) {
//                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    if(Thread.currentThread().getName().equals("线程1"))
                        System.out.println(Thread.currentThread().getName() + ":" + 1);
                    else
                        System.out.println(Thread.currentThread().getName() + ":" + 2);
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
    }
    public static void main(String[] args) {
        /*只有一个TestThread+对象*/
        TestThread12 t = new TestThread12();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}