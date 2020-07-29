package ClassTest;

class Animal{
    int leg;

    Animal(int n){
        leg = n;
    }

    public void move(){
        System.out.println("animal can move.");
    }
}
public class Dog extends Animal{
    Dog(int n){
        super(n);
    }
    public void move(){
        System.out.println("dog can run.");
    }
    public void move(int leg){
        System.out.println("dog can run with "+ leg + "legs");
    }
    public static void main(String[] args) {
        Dog d = new Dog(4);
        d.move();
        d.move(4);
    }
}

