import java.util.*;
import java.lang.Math;

class sub1 extends TestAny{

}
class sub2 extends TestAny{

}
public class TestAny {

    public static void main(String arg[]) throws Exception {
        TestAny a = null, b = a;
        a = new TestAny();
        System.out.println(a);
        System.out.println(b);
    }
}
