package DesignPattern.Factory.AbstractFactory;

import DesignPattern.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderMailFactory senderMailFactory = new SenderMailFactory();
        Sender sender = senderMailFactory.produce();
        sender.send();
    }
}
