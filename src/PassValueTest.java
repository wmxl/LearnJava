class B{
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public B(int value) {
        this.value = value;
    }
}


public class PassValueTest {
    public static void changeValue(B b1, B b2){
        b1 = b2;
    }
    public static void changeValue2(B b1, B b2){
        int v = b2.getValue();
        b1.setValue(v);
    }

    public static void main(String[] args) {
        B b1 = new B(3);
        B b2 = new B(8);

        changeValue(b1, b2);

        System.out.println(b1.getValue());

        changeValue2(b1, b2);

        System.out.println(b1.getValue());

    }
}
