package JAVA.NeiBuLei;

/*
内部类有四种: 普通内部类，静态内部类，局部内部类，匿名内部类
 */

public class OutClass {
    private int normalInt = 3;
    private static int staticInt = 4;

    class InnerClass{
        private int a = 1;
//        private static int b = 1;//普通内部类不能有静态成员（变量，方法）
        void out(){
            //普通内部类可以访问外部类的静态成员和非静态成员
            System.out.println(staticInt);
            System.out.println(normalInt);
        }

    }
    static class StaticInnerClass{
        private int a = 1;
        public int C = 0;
        private static int b = 1;//静态内部类可以有静态成员（变量，方法）
        void out(){
            System.out.println(staticInt); //静态内部类只可以访问外部类的静态成员
//            System.out.println(normalInt); // 静态内部类不可访问外部类的非静态成员
        }
    }

    public void test(){

//        System.out.println(a);// 错误 普通方法不能直接调用内部类的变量
        System.out.println(new InnerClass());// 正确 普通方法可以直接通过new内部类来调用私有变量
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
