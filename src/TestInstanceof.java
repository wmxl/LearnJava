class Animal{
	String name;
}
class Dodg extends Animal{
	int leg;
}
class Cat extends Animal{
	int leg;
}
class Car{
	int wheel; 
}

public class TestInstanceof {
	public static void main(String[] args){
		Animal a1 = new Animal();
		Dodg d1 = new Dodg();
		Cat c1 = new Cat();
		Car c2 = new Car();

		System.out.println(d1 instanceof Dodg); //ture
		System.out.println(d1 instanceof Animal);  //true
		System.out.println(a1 instanceof Dodg);  //false
//		System.out.println(c1 instanceof Dodg);  //直接报错，而不是返回false
//		System.out.println(c2 instanceof Animal); //直接报错，而不是返回false
			
	}
}
