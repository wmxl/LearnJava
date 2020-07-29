package DesignPattern.Factory.SimpleFactory;

import DesignPattern.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produce("mail");
        sender.send();
    }
}
