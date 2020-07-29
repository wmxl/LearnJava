package NeiBuLei;

/*
内部类有四种: 普通内部类，静态内部类，局部内部类，匿名内部类
 */

public class OutClass {
    class InnerClass{
        private int a = 1;
    }
    static class StaticInnerClass{
        private int b = 2;
    }
    public void test(){
//        System.out.println(a);// 错误 普通方法不能直接调用私有变量
        System.out.println(new InnerClass().a);// 正确 普通方法可以直接通过new内部类来调用私有变量
        System.out.println(new StaticInnerClass().b); //普通方法可以直接调用 静态内部类的私有变量

        class LocalClass{
            private int c = 3;
        }
        System.out.println(new LocalClass().c); //局部内部类只能再局部（函数内）使用
    }
    public static void main(String[] args) {
//        new InnerClass().a;
//        System.out.println(new InnerClass().a); //报错 静态方法 new普通内部类也不能调用
        System.out.println(new OutClass().new InnerClass().a); //成功 但是可以先new外部类，然后再.内部类
        System.out.println(new StaticInnerClass().b); //静态内部类 可以直接调用

        new OutClass().test();
    }
}
