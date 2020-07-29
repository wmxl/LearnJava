package MultiThread;

class A implements Runnable
{
    @Override
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("Hello "+Thread.currentThread().getName());
            try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        A a1 = new A();
        Thread t1 = new Thread(a1, "First");
        Thread t2 = new Thread(a1,"Second");
        Thread t3 = new Thread(a1, "Third");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        System.out.println("Good bye...");
    }
}