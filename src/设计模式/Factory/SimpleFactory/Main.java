package 设计模式.Factory.SimpleFactory;

import 设计模式.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produce("mail");
        sender.send();
    }
}
