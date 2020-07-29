package StringAndStringBuffer;
/*
字符串截取
 */
public class SubString {
    public static void main(String[] args) {
        System.out.println("--------------String-----------------------");
        String s1 = "abcdefg";
        //截取pos从1到最后的字符串
        System.out.println(s1.substring(1));
        //截取pos从1到3结束的字符串(不包括3）
        System.out.println(s1.substring(1,3));

        //StringBuffer和String用法完全一样
        System.out.println("--------------StringBuffer-----------------------");
        StringBuffer sb = new StringBuffer("abcdefg");
        sb.substring(1);
        System.out.println(sb.substring(1));
        System.out.println(sb.substring(1,3));



    }
}
