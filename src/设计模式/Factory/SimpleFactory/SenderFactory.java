package 设计模式.Factory.SimpleFactory;

import 设计模式.Factory.MailSender;
import 设计模式.Factory.Sender;
import 设计模式.Factory.SmsSender;

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