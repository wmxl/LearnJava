package HuHomework.log;

public class TextLog extends Log implements trigger{
    public TextLog(){}

    public TextLog(String name, String description, String data) {
        super(name, description, data);
    }

    @Override
    public void action() {
        System.out.println("Automatic translate");
    }
    @Override
    public boolean isLegal() {
        return true;
    }
}
