package DesignPattern.Factory.MultiFactory;

import DesignPattern.Factory.Sender;
import DesignPattern.Factory.MailSender;
import DesignPattern.Factory.SmsSender;

public class SenderFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}