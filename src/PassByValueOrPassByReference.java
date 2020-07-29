/**
http://www.javadude.com/articles/passbyvalue.htm
 */
class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class PassByValueOrPassByReference {
    public static void foo(Dog someDog) {  // AAA
        someDog.setName("Max");     // BBB
        someDog = new Dog("Fifi");  // CCC
        someDog.setName("Rowlf");   // DDD
    }

    public static void main(String[] args) {
        Dog myDog = new Dog("Rover");
        foo(myDog);
        System.out.println(myDog.getName());
    }
}
/*
Let's look at what's happening.

line AAA
the parameter someDog is set to the value 42

line BBB
someDog is followed to the Dog it points to (the Dog object at address 42)
that Dog (the one at address 42) is asked to change his name to "Max"

line CCC
a new Dog is created. Let's say he's at address 74.
we assign the parameter someDog to that address, 74

line DDD
someDog is followed to the Dog it points to (the Dog object at address 74)
that Dog (the one at address 74) is asked to change his name to "Rowlf"

 */