package HuHomework;
class FatherClass{
    public void fatherMethod(){
        System.out.println("This is parent class" );
    }

}
class ChildClass extends FatherClass{
    public void ChildMethod(){
        System.out.println("This is child class" );
    }
}
public class Test {

    public static void main(String[] args) {
        FatherClass fc = new FatherClass();
        ChildClass cc = new ChildClass();
        fc.fatherMethod();
        cc.ChildMethod();
        cc.fatherMethod();
    }
}
