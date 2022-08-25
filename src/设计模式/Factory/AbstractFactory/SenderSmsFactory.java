package 设计模式.Factory.AbstractFactory;

import 设计模式.Factory.Sender;
import 设计模式.Factory.SmsSender;

public class SenderSmsFactory implements Provider {

    @Override
    public Sender produce(){
        return new SmsSender();
    }
}