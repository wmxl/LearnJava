package ClassTest;

class Shape {
    public void shape(){
        System.out.println("this is a shape.");
    }
}

class Rectangle extends Shape {
    public void rectangle(){
        System.out.println("this is a rectangle shape.");
    }
}
class Circle extends Shape {

    public void circle(){
        System.out.println("this is a circle shape.");
    }
}
class Square extends Rectangle{
    public void square(){
        System.out.println("this is a square shape.");
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Square s = new Square();
        s.shape();
        s.rectangle();
    }
}
