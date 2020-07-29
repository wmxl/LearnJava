package StringAndStringBuffer;

public class StringReplace {
    public static void main(String[] args) {
        System.out.println("-------String-------");
        String s = "helloWorld";
        String s1 = s.replace("he","xx");
        String s2 = s.replace('l','x');
        String s3 = s.replace("l","x");
        String s4 = s.replaceFirst("l","x");
        System.out.println(s);  //String的replace，返回的值才是修改后的字符串
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println("-------StringBuffer-------");
        StringBuffer sb = new StringBuffer("helloWorld");
        sb.replace(0,1,"xx");
        System.out.println(sb); //StringBuffer的replace，调用完，本身就会被修改
        StringBuffer sb1 = new StringBuffer("helloWorld");
        sb1.replace(0,5,"xx");
        System.out.println(sb1);
    }
}
