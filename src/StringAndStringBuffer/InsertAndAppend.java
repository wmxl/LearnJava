package StringAndStringBuffer;

public class InsertAndAppend {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("aaa");
        System.out.println(sb);  //调用insert方法前结果：aaa
        sb.insert(1,"bbb");
        System.out.println(sb);  //调用insert方法后结果：abbbaa

        StringBuffer str = new StringBuffer("aaa");
        str.append("01234",1,3);
        System.out.println(str.toString());
    }
}
