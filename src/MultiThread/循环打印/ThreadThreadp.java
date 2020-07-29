package MultiThread.循环打印;
class PrintA implements Runnable{
    private  ThreadThreadp t;
    PrintA(ThreadThreadp t){
        this.t=t;
    }
    @Override
    public void run() {
        try {
            t.printa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PrintB implements Runnable{

    private  ThreadThreadp t;
    PrintB(ThreadThreadp t){
        this.t=t;
    }
    @Override
    public void run() {
        try {
            t.printb();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PrintC implements Runnable{
    private  ThreadThreadp t;
    PrintC(ThreadThreadp t){
        this.t=t;
    }
    @Override
    public void run() {
        try {
            t.printc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadThreadp {
    private int flag = 0;
    public synchronized void printa() throws InterruptedException {
        while (true)
        {
            if(flag ==0)
            {
                System.out.print("A");
                flag = 1;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized   void printb() throws InterruptedException {
        while (true)
        {
            if(flag ==1)
            {
                System.out.print("B");
                flag = 2;
                notifyAll();
            }
            wait();
        }
    }
    public synchronized void printc() throws InterruptedException {
        while (true) {
            if (flag == 2) {
                System.out.print("C");
                Thread.sleep(1000);
                flag = 0;
                notifyAll();
            }
            wait();
        }
    }
    public static void main(String[]args) throws InterruptedException
    {
        ThreadThreadp t = new ThreadThreadp();
        PrintA printA = new PrintA(t);
        PrintB printB = new PrintB(t);
        PrintC printC = new PrintC(t);
        Thread t1 = new Thread(printA);
        Thread t2 = new Thread(printB);
        Thread t3 = new Thread(printC);
        t1.start();
        t2.start();
        t3.start();
        //Thread t11 = new Thread(printA);
        //Thread t21 = new Thread(printB);
        //Thread t31 = new Thread(printC);
        //t11.start();
        //t21.start();
        //t31.start();

    }

}

