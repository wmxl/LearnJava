package Reflect;


class Derived extends Base { }

public class Main2 {
    public static void main(String[] args) {
        Base base = new Derived();
        if (base instanceof Derived) {
            // 这里可以向下转换了
            System.out.println("ok");
        }
        else {
            System.out.println("not ok");
        }
    }
}