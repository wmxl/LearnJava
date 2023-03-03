package 设计模式.Factory.AbstractFactory;

import 设计模式.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderMailFactory senderMailFactory = new SenderMailFactory();
        Sender sender = senderMailFactory.produce();
        sender.send();
    }
}
