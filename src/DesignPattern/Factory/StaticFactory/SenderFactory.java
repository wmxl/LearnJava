package DesignPattern.Factory.StaticFactory;

import DesignPattern.Factory.MailSender;
import DesignPattern.Factory.Sender;
import DesignPattern.Factory.SmsSender;

public class SenderFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}