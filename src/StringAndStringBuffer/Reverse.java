package StringAndStringBuffer;

public class Reverse {
    public static StringBuffer myReverse(StringBuffer sb) {
        int len = sb.length();
        for (int i = 0; i < len / 2; i++) {
            char ci = sb.charAt(i);
            char cj = sb.charAt(len - 1 - i);
            System.out.println(ci + " " + cj);
            sb.setCharAt(i, cj);
            sb.setCharAt(len - 1 - i, ci);
        }
        return sb;
    }

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("abcdefg");
        sb.reverse();
        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer("012");
        StringBuffer sb2 = new StringBuffer("0123");

        System.out.println(myReverse(sb1));
        System.out.println(myReverse(sb2));


    }
}
