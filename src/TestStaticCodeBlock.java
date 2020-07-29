public class TestStaticCodeBlock {
    static {
        int a = 1;
        System.out.println(a);
    }
    static int a = 2;
    static {
        System.out.println(a);
    }

    public static void main(String[] args) {
        new TestStaticCodeBlock();
    }
}
