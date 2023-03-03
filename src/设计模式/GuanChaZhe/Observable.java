package 设计模式.GuanChaZhe;

import java.util.Vector;

public class Observable {
    private boolean changed = false;
    private Vector<Observer> obs;//观察者列表

    public Observable() {
        obs = new Vector<>();
    }

    //注册观察者到观察者列表（即obs）
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    //通知观察者更新
    public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!hasChanged())//如果内容没有变即标志位为flase，则返回
                return;
            arrLocal = obs.toArray();//否则将obs转换为数组
            clearChanged();//设置标志位为false
        }
        //遍历观察者，通知它们更新
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }

    //设置标志位为true
    protected synchronized void setChanged() {
        changed = true;
    }

    //设置标志位为false
    protected synchronized void clearChanged() {
        changed = false;
    }

    //判单标志位
    public synchronized boolean hasChanged() {
        return changed;
    }
}