package HuHomework.log;

import java.util.LinkedList;

class Controller {

    // 仓库容量
    private final int MAX_SIZE = 5;
    // 仓库存储的载体
    private LinkedList<Log> list = new LinkedList<>();

    public void produce(Log log) {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println(Thread.currentThread().getName()
                        + "queue is full");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(log);
            System.out.println( Thread.currentThread().getName()
                    + "upload one file, queue's size now: " + list.size());
            list.notifyAll();
        }
    }

    public long consume() {
        long time = 0;
        synchronized (list)
        {
            // 如果仓库存储量不足
            while (list.size() == 0)
            {
                System.out.println("queue is empty: " + list.size() + "\t can not process now");
                try
                {
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            Log log = list.removeFirst();
            if(log instanceof VideoLog){
                ((VideoLog) log).action();
            }else if(log instanceof AudioLog){
                ((AudioLog) log).action();
            }

            time = (long)log.getSize();

            System.out.println("processing:" + log + "\t queue size now:" + list.size());

            list.notifyAll();
        }
        return time;
    }
}


 class upload implements Runnable{
    private Controller storage;
    private Log log;

    public upload(){}

    public upload(Controller storage, Log log ){
        this.storage = storage;
        this.log = log;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                storage.produce(log);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class ExternalService implements Runnable{
    private Controller storage;
    private long time;
    public ExternalService(){}

    public ExternalService(Controller storage ){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            try{
                time = storage.consume();
                Thread.sleep(time);
                System.out.println("【processing spent】"+ time + "time(ms)");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


public class Main3 {

    public static void main(String[] args) {
        Controller storage = new Controller();

        VideoLog vl1 = new VideoLog("first videoLog", "viedo log", "21214141",3000.0,"mp4");
        VideoLog vl2 = new VideoLog("second videoLog", "viedo log", "21214141",2000.0,"mp4");
        AudioLog al1 = new AudioLog("first AudioLog", "audio log", "21214141",1000.0,"jpg");

        Thread p1 = new Thread(new upload(storage, vl1));
        Thread p2 = new Thread(new upload(storage, vl2));
        Thread p3 = new Thread(new upload(storage, al1));

        Thread c1 = new Thread(new ExternalService(storage));


        p1.start();
        p2.start();
        p3.start();
        c1.start();

    }
}
