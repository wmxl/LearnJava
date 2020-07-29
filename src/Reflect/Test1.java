package Reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test1 {

    private String prop1;
    private Integer prop2;
    private Double prop3;

    public String getProp1() {
        return prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public Integer getProp2() {
        return prop2;
    }

    public void setProp2(Integer prop2) {
        this.prop2 = prop2;
    }

    public Double getProp3() {
        return prop3;
    }

    public void setProp3(Double prop3) {
        this.prop3 = prop3;
    }

    private void printPrivate(){
        System.out.println("this is a private fatherMethod");
    }


    public static void main(String[] args) throws Exception{

        Test1 test1 = new Test1();
        test1.setProp1("Hello");
        test1.setProp2(100);

        Class clazz = Test1.class;//获取Class对象方式1
        Class clazz2 = Class.forName("Reflect.Test1");//获取Class对象方式2

        String clazzName = clazz.getName();//获取类名，含包名
        String clazzSimpleName = clazz.getSimpleName();//获取类名，不含包名
        System.out.println("getName：" + clazzName + "\tgetSimpleName：" + clazzSimpleName);

        int mod = clazz.getModifiers();//获取类修饰符
        System.out.println("Modifier.isPublic:" + Modifier.isPublic(mod));//判断类修饰符
        System.out.println("Modifier.isProtected:" + Modifier.isProtected(mod));//判断类修饰符

        Package p = clazz.getPackage();//获取包
        System.out.println("getPackage：" + p);

        Class superClass = clazz.getSuperclass();//获取父类
        System.out.println("getSuperclass：" + superClass);

        Class[] interfaces = clazz.getInterfaces();//获取实现接口
        System.out.println("getInterfaces:" + interfaces.length);

        Constructor[] cons = clazz.getConstructors();//构造方法
        System.out.println("getConstructors:" + cons.length);

        Method[] methods = clazz.getMethods();//获取所有方法
        System.out.println("getMethods:" + methods.length);
        for (Method method : methods) {
            System.out.println("fatherMethod.getName:" + method);
        }
        methods = clazz.getDeclaredMethods();//获取私有方法
        System.out.println("getMethods:" + methods.length);
        for (Method method : methods) {
            System.out.println("fatherMethod.getName:" + method.getName());
        }
        System.out.println("----------------------------------------------");
        Method method = clazz.getDeclaredMethod("printPrivate");//获取指定私有方法
        System.out.println("getDeclaredMethod(,):" + method);
        Object methodVlaue = method.invoke(test1, null);//调用方法
        System.out.println("fatherMethod.invoke(,):" + methodVlaue);

        Method method1 = clazz.getMethod("getProp1", null);//获取指定方法
        System.out.println("getMethod(,):" + method1);
        Object methodVlaue1 = method1.invoke(test1, null);//调用方法
        System.out.println("fatherMethod.invoke(,):" + methodVlaue1);

        Method method3 = clazz.getMethod("setProp3", Double.class);//获取指定方法
        System.out.println("getMethod(,):" + method3);
        Object methodVlaue3 = method3.invoke(test1, 2.0);//调用setter方法，该方法没有返回值，所以methodVlaue3为null；此处注意参数2.0 ，不能用null
        System.out.println("fatherMethod.invoke(,):" + methodVlaue3);

        Field[] fields = clazz.getDeclaredFields();//获取变量
        System.out.println("getDeclaredFields:" + fields.length);
        for (Field field : fields) {
//            field.setAccessible(true);
            System.out.println(field.isAccessible());//这里的结果是false
            // 为啥结果是false还是可以获得私有变量？ 答：因为在一个类里，换一个类就不行了！

//            field.set(test1, null);//设置字段的值
            System.out.println("field.getAnnotations:" + field.getAnnotations().length + "\tfield.getName:" + field.getName() + "\tfield.get:" + field.get(test1));//获取实例属性名和值

        }

        Annotation[] annos = clazz.getAnnotations();//获取类注解
        System.out.println("getAnnotations:" + annos.length);

    }
}