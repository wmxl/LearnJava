package DesignPattern.Factory.MultiFactory;

import DesignPattern.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        SenderFactory factory = new SenderFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }

}
