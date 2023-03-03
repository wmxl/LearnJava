package MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class Sleep0 {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (long i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
            }
            System.out.println(Thread.currentThread().getName()+"执行结束!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}

/*
有时间研究下这两篇
https://www.cnblogs.com/thisiswhy/p/16657667.html#!comments
https://mp.weixin.qq.com/s/KDUccdLALWdjNBrFjVR74Q

sleep(0)的作用
https://blog.csdn.net/qiaoquan3/article/details/56281092/

吞异常
https://blog.csdn.net/Soda_lw/article/details/115429919
 */