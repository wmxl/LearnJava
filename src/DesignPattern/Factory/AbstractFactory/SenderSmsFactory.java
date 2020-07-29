package DesignPattern.Factory.AbstractFactory;

import DesignPattern.Factory.Sender;
import DesignPattern.Factory.SmsSender;

public class SenderSmsFactory implements Provider {

    @Override
    public Sender produce(){
        return new SmsSender();
    }
}