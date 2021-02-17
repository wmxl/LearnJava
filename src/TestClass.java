class A {
    int value;

    public A(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class TestClass {
    public static void changeValue(A a1, A a2) {
        a1 = a2;
    }//这只是改变了指向Object的局部变量指针的值，所以method外面是不会改变的

    public static void changeValue2(A a1, A a2) { //这里是对局部变量的指针指向的Object进行set操作，所以method外也会改变
        int v = a2.getValue();
        a1.setValue(v);
    }

    public static void main(String[] args) {
        A a1 = new A(3);
        A a2 = new A(8);

        changeValue(a1, a2);
        System.out.println(a1.value); //3

        a1 = new A(3);
        a2 = new A(8);

        changeValue2(a1, a2);
        System.out.println(a1.value); //8
    }
}
