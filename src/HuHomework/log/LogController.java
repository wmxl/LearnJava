package HuHomework.log;

import java.util.LinkedList;

public class LogController
{
    // 仓库最大存储量
    private final int MAX_SIZE = 5;

    // 仓库存储的载体
    private LinkedList<Log> list = new LinkedList<Log>();

    // 生产num个产品
    public void upload(Log log)
    {
        // 同步代码段
        synchronized (list)
        {
            // 如果仓库剩余容量不足
            while (list.size() + 1 > MAX_SIZE)
            {
                System.out.println("queue is full:" + "\t can not upload log now");
                try
                {
                    // 由于条件不满足，生产阻塞
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            // 生产条件满足情况下，生产1个产品
            list.add(log);

            System.out.println("upload one log file:" + "\t queue size now:" + list.size());

            list.notifyAll();
        }
    }

    // 消费num个产品
    public void process()
    {
        // 同步代码段
        synchronized (list)
        {
            // 如果仓库存储量不足
            while (list.size() == 0)
            {
                System.out.println("queue is empty" + list.size() + "\t can not process now");
                try
                {
                    // 由于条件不满足，消费阻塞
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
            System.out.println("processing:" + log + "\t queue size now:" + list.size());

            list.notifyAll();
        }
    }

    // get/set方法
    public LinkedList<Log> getList()
    {
        return list;
    }

    public void setList(LinkedList<Log> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}

class Upload extends Thread
{
    private Log log;

    // 所在放置的仓库
    private LogController logQueue;

    // 构造函数，设置仓库
    public Upload(LogController storage, Log log)
    {
        this.logQueue = storage;
        this.log = log;
    }

    // 线程run函数
    public void run()
    {
        long time = (long)log.getSize();
        upload(log);
        try{
            Thread.sleep(time);
            logQueue.process();
            System.out.println("【processing spent】"+ time + "time(ms)");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    // 调用仓库Storage的生产函数
    public void upload(Log log)
    {
        logQueue.upload(log);
    }
}