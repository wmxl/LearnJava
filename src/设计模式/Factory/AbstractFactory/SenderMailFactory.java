package 设计模式.Factory.AbstractFactory;

import 设计模式.Factory.MailSender;
import 设计模式.Factory.Sender;

public class SenderMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}