package 设计模式.Factory.MultiFactory;

import 设计模式.Factory.Sender;
import 设计模式.Factory.MailSender;
import 设计模式.Factory.SmsSender;

public class SenderFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}