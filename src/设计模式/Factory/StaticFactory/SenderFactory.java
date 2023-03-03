package 设计模式.Factory.StaticFactory;

import 设计模式.Factory.MailSender;
import 设计模式.Factory.Sender;
import 设计模式.Factory.SmsSender;

public class SenderFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}