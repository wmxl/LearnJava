package JAVA.InterfacAndAbstractClass;

interface Alarm {
    void alarm();

    static void staticDescribe() { //接口中的可以有静态方法 ， 直接用Alarm.describe()调用
        System.out.println("alarm");
    }

    default void describe() { //接口中的非抽象方法 必须是 default修饰
        System.out.println("alarm");
    }
}

abstract class Door {
    public abstract void open();  //抽象类也可以一个抽象方法都没有

    public abstract void close();

    public static void staticDescribe() {  //抽象类可以有抽象方法
        System.out.println("door");
    }

    public void describe() {  //抽象类可以有抽象方法
        System.out.println("door");
    }
}

public class AlarmDoor extends Door implements Alarm {
    public void open() {
        System.out.println("open");
    }

    public void close() {
        System.out.println("close");
    }

    public void alarm() {
        System.out.println("alarm");
    }

    public static void main(String[] args) {
        AlarmDoor ad = new AlarmDoor();

        ad.describe(); //如果接口和抽象类有同名方法， 会优先调用抽象类的方法

        Alarm.staticDescribe(); //直接调用接口的静态方法

        Door.staticDescribe(); //直接调用抽象类的静态方法

    }
}
