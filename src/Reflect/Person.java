package Reflect;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Person implements Serializable {

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void printPrivate(){
        System.out.println("this is a private fatherMethod");
    }

    private String name;
    private int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // get/set方法
    public static void main(String[] args) throws Exception {
        Person person = new Person("Tony", 29);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
            Method method = descriptor.getReadMethod();
            Object value = method.invoke(person);
            System.out.println(key + ":" + value);
        }
    }
}
