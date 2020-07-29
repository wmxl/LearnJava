package HuHomework;

class Members{
    String name;
    int age;
    String phoneNumber;
    String address;
    String salary;

    public Members(String name, int age, String phoneNumber, String address, String salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary(){
        System.out.println(this.name + "'s salary is "+this.salary);
    }
}
class Employee extends Members{
    String specialization;

    public Employee(String name, int age, String phoneNumber, String address, String salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }
}
class Manager extends Members{
    String department;

    public Manager(String name, int age, String phoneNumber, String address, String salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }
}
public class MemberTest {

    public static void main(String[] args) {
        Employee e = new Employee("Bob",19,"18323923923", "Boston","3000","xxx");
        Manager m = new Manager("John",19,"18323923923", "Boston","4000","xxx");
        e.printSalary();
        m.printSalary();
    }
}
