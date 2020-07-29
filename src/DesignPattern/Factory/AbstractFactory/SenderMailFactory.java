package DesignPattern.Factory.AbstractFactory;

import DesignPattern.Factory.MailSender;
import DesignPattern.Factory.Sender;

public class SenderMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}