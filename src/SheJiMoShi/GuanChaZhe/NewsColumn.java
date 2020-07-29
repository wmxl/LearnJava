package SheJiMoShi.GuanChaZhe;

public class NewsColumn extends Observable {

    /**
     * 发布新闻
     * @param content 新闻内容
     */
    public void postNews(String content){
        //设置标志位为true，表示有新内容
        setChanged();
        //通知所有观察者（即订阅了这新闻的人们）
        notifyObservers(content);
    }

}