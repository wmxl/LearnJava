import java.util.*;
import java.lang.Math;

class sub1 extends TestAny{

}
class sub2 extends TestAny{

}
public class TestAny {

    public static void main(String arg[]) throws Exception {
        Object a = null, b = new TestAny();
        a = new TestAny();

        //对于没有重写hashCode的方法，System.identityHashCode(a)和a.hashCode()的结果是一样的


        String classNameOfA = a.getClass().getName();
        String classNameOfB = b.getClass().getName();

        System.out.println(classNameOfA);
        System.out.println(classNameOfB);
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());


        int d = classNameOfA.compareTo(classNameOfB);
        System.out.println(d);

        boolean res = (d = classNameOfA.compareTo(classNameOfB)) == 0;


        System.out.println("d = " + d);

//        String a1 = null;
//        String b1 = new String("hello");
//
//        //重写了hashCode的方法，System.identityHashCode(a1)是根据地址计算出来的hash值，a.hashCode()是自己重写的规则计算的hash值
////        System.out.println(a1.getClass());
//        System.out.println(b1.getClass().getName());
//        System.out.println(System.identityHashCode(a1));
//        System.out.println(System.identityHashCode(b1));
////        System.out.println(a1.hashCode());
//        System.out.println(b1.hashCode());

    }
}
