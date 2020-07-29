package HuHomework;

abstract class Shape {
    abstract public void method();
}

class Rectangle extends Shape {
    public void method(){
        System.out.println("this is a rectangle shape.");
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Rectangle s = new Rectangle();
        s.method();
    }
}
