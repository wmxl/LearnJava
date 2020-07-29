package MultiThread.循环打印;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

class MyRunable1 implements Runnable{
    private TestThread121v2 t;
    public MyRunable1(TestThread121v2 t) {
        this.t = t;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 999; i++) {
            synchronized (t.object) {
                t.object.notify();
                if ( t.flag % 3 == 0 || t.flag % 3 == 2 ) {
                    System.out.println(Thread.currentThread().getName() + " 1");
                    t.flag++;
                    try {
                        t.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
class MyRunable2 implements Runnable{
    private TestThread121v2 t;
    public MyRunable2(TestThread121v2 t) {
        this.t = t;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 999; i++) {
            synchronized (t.object) {
                t.object.notify();
                if ( t.flag % 3 == 1 ) {
                    System.out.println(Thread.currentThread().getName() + " 2");
                    t.flag++;
                    try {
                        t.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
public class TestThread121v2 {

        public static Object object = new Object();
        public static int flag = 0;
        public static void main(String[] args) {

            TestThread121v2 thread = new TestThread121v2();

            MyRunable1 r1 = new MyRunable1(thread);
            MyRunable2 r2 = new MyRunable2(thread);

            Thread t1 = new Thread(r1,"线程1");
            Thread t2 = new Thread(r2,"线程2");

            t1.start();
            t2.start();
        }
    }