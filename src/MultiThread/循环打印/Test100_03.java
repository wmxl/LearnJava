package MultiThread.循环打印;

/**
 * created by cjy
 * desc: synchronized wait notify
 */

public class Test100_03 {

    private static Object object = new Object();
    private static int flag = 0;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            int t = 10;
            for (int i = 1; i <= 999; i++) {
                synchronized (object) {
                    object.notify();
                    if ( flag % 3 == 0 ) {
                        System.out.println("A");
                        flag++;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 999; i++) {
                synchronized (object) {
                    object.notify();
                    if (flag % 3 == 1) {
                        flag++;
                        System.out.println("B");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 999; i++) {
                synchronized (object) {
                    object.notify();

                    if (flag % 3 == 2) {
                        flag++;
                        System.out.println("C");
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}