package 设计模式.Factory.MultiFactory;

import 设计模式.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }

}
