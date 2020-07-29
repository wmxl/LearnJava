package HuHomework.log;

public class Main {
    public static void main(String[] args) {
        Logs logs = new Logs();
        LogFactory factory = new LogFactory();

        TextLog tl1 = new TextLog("first textLog", "text", "2121414");
        TextLog tl2 = new TextLog("second textLog", "text2", "21214141");
        AudioLog al1 = (AudioLog)factory.makeLog("mp3");
        VideoLog vl1 = (VideoLog)factory.makeLog("avi");
        ImageLog pl1 = (ImageLog)factory.makeLog("jpg");

        tl1.action();
        tl2.action();
        vl1.action();
        pl1.action();
        al1.action();

        logs.uploadLog(tl1);
        logs.uploadLog(tl2);
        logs.uploadLog(vl1);
        logs.uploadLog(pl1);
        logs.uploadLog(al1);
        logs.showAllLog();
        logs.showLogNumber();

        logs.readLog(tl1.getInternalID());
        logs.readLog(tl1.getInternalID());

        logs.updateLog(tl1.getInternalID(),"cde","cdeffff","1111");
        logs.readLog(tl1.getInternalID());

        logs.deleteLog(tl1.getInternalID());
        logs.readLog(tl1.getInternalID());

        logs.showAllLog();
        logs.showLogNumber();
    }
}
