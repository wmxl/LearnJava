package wmxlUtils;

//import static wmxlUtils.StringUtils.compareTest;

public class TestUtils {
    public static void main( String[] args )
    {
        String s1 = "abcdef abcdefg abeod";
        String s2 = "abcdef abcdefg abbod";

        System.out.println(wmxlUtils.StringUtils.compareTest(s1, s2, 6));
    }
}
