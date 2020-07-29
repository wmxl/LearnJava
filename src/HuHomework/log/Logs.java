package HuHomework.log;

import java.util.ArrayList;

public class Logs {
    static ArrayList<Log> logList = new ArrayList<>();

    public void uploadLog(Log log){
        if(log instanceof TextLog){
            if(((TextLog) log).isLegal()){
                ((TextLog) log).action();
                logList.add(log);
            }
        }else if(log instanceof ImageLog){
            if(((ImageLog) log).isLegal()){
                logList.add(log);
            }
        }else if(log instanceof AudioLog){
            if(((AudioLog) log).isLegal()){
                logList.add(log);
            }
        }else if(log instanceof VideoLog){
            if(((VideoLog) log).isLegal()){
                logList.add(log);
            }
        }else{
            System.out.println("Error");
        }
    }

    public boolean updateLog(long id, String name, String des, String data){
        for(Log l : logList){
            if(l.getInternalID() == id){
                l.update(name, des, data);
                System.out.println("update successfully!");
                return true;
            }
        }
        System.out.println("can't find data!");
        return false;
    }

    public boolean deleteLog(long id){
        for(Log l : logList){
            if(l.getInternalID() == id){
                logList.remove(l);
                System.out.println("delete successfully!");
                return true;
            }
        }
        System.out.println("can't find data!");
        return false;
    }

    public void readLog(long id){
        boolean flag = false;
        for(Log l : logList){
            if(l.getInternalID() == id){
                l.read();
                flag = true;
            }
        }
        if(!flag)
            System.out.println("can't find data!");
    }

    public void showAllLog(){
        System.out.println("-----------");
        for(Log l : logList){
            l.read();
            System.out.println();
        }
        System.out.println("-----------");
    }
    public void showLogNumber(){
        System.out.println(logList.size());
    }

}
