package HuHomework.log;

import java.util.LinkedList;



public class Main2
{
    public static void main(String[] args)
    {
        // 仓库对象
        LogController storage = new LogController();

        VideoLog vl1 = new VideoLog("first videoLog", "viedo log", "21214141",3000.0,"mp4");
        VideoLog vl2 = new VideoLog("second videoLog", "viedo log", "21214141",2000.0,"mp4");
        AudioLog al1 = new AudioLog("first AudioLog", "audio log", "21214141",1000.0,"jpg");

        // 生产者对象
        Upload p1 = new Upload(storage, vl1);
        Upload p2 = new Upload(storage, vl2);
        Upload p3 = new Upload(storage, vl1);
        Upload p4 = new Upload(storage, vl1);
        Upload p5 = new Upload(storage, vl1);
        Upload p6 = new Upload(storage, vl1);
        Upload p7 = new Upload(storage, vl1);
        Upload p8 = new Upload(storage, vl1);
        Upload p9 = new Upload(storage, vl2);
        Upload p10 = new Upload(storage, al1);
        Upload p11 = new Upload(storage, vl1);
        Upload p12 = new Upload(storage, al1);
        Upload p13 = new Upload(storage, vl1);
        Upload p14 = new Upload(storage, al1);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        p10.start();
        p11.start();
        p12.start();
        p13.start();
        p14.start();
    }
}
