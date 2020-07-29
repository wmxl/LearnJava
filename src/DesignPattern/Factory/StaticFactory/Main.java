package DesignPattern.Factory.StaticFactory;

import DesignPattern.Factory.Sender;

public class Main {
    public static void main(String[] args) {
        Sender sender = SenderFactory.produceMail();
        sender.send();
    }

}
