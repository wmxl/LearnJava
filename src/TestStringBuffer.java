public class TestStringBuffer {
    public static void changeStringBuffer(StringBuffer ss1, StringBuffer ss2) {
        ss1 = ss1.append(" world");        //append会改变ss1的对象
        ss2 = ss1;                         //ss2 只在这个method里会改变，出了这个method，还是原来的值

        System.out.println("ss2 = " + ss2);
    }

    public static void changeString(String ss1, String ss2) {
        ss1 += " world";
        ss2 = ss1;
        System.out.println("ss2 = " + ss2);
    }

    public static void main(String[] args) {

        Integer a = 1; //包装类是不可变类
        Integer b = a;
        b++;
        System.out.println(a);
        System.out.println(b);

        System.err.println("----");

        StringBuffer s1 = new StringBuffer("Hello");
        StringBuffer s2 = new StringBuffer("Hello");
        changeStringBuffer(s1, s2);
        System.out.println("s1 = " + s1);   //method执行后s1的值被修改了
        System.out.println("s2 = " + s2);

        System.err.println("----");

        String s3 = new String("Hello");
        String s4 = new String("Hello");
        changeString(s3, s4);

        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

        System.err.println("--end--");

        //改变其中一个字符
        StringBuffer sb1 = new StringBuffer("hello world");
        sb1.setCharAt(5,'|');
        System.out.println(sb1);
        //插入一段字符
        sb1.insert(8,"0000");
        System.out.println(sb1);

    }
}
