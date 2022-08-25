package 设计模式.GuanChaZhe;

public class SubScriber implements Observer {

    private String name;

    public SubScriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("你好！" + name + ", 新闻专栏更新啦！" + arg);
    }

    @Override
    public String toString() {
        return "订阅者： " + name;
    }
}