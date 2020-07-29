package DesignPattern.Factory.SimpleFactory;

import DesignPattern.Factory.MailSender;
import DesignPattern.Factory.Sender;
import DesignPattern.Factory.SmsSender;

public class SenderFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}