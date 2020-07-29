package MultiThread.循环打印;

/**
 * created by cjy
 * desc: synchronized wait notify
 */
public class Test100_02 {

    private static Object object = new Object();
    private static boolean isFlag = false;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 999; i+=2) {
                synchronized (object) {
                    if (!isFlag) {
                        System.out.println("current:" + i);
                        isFlag = true;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        object.notify();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= 1000; i+=2) {
                synchronized (object) {
                    if (isFlag) {
                        isFlag = false;
                        System.out.println("current:" + i);
                        object.notify();

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
    }
}