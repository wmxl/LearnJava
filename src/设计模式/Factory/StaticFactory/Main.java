package 设计模式.Factory.StaticFactory;

import 设计模式.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        Sender sender = SenderFactory.produceMail();
        sender.send();
    }

}
