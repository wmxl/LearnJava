package MultiThread.this和currentThread的区别;


public class MyThread extends Thread {
    public MyThread() {
        this.setName("A");
        System.out.println("currentThread()线程的名字：" + Thread.currentThread().getName());
        System.out.println("this线程的名字：" + this.getName());
    }

    @Override
    public void run() {
        System.out.println("currentThread()线程的名字：" + Thread.currentThread().getName() + "   run==" + Thread.currentThread().isAlive());
        System.out.println("this线程的名字：" + this.getName() + "  run==" + this.isAlive());
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //初始化Thread对象，方便调用start();
        //此时myThread作为参数传入Thread中，其实是myThread委托thread去执行；
        Thread thread = new Thread(myThread);
        //初始化自定义线程名称
        thread.setName("C");
        //启动线程
        thread.start();

    }
}

