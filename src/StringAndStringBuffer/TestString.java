package StringAndStringBuffer;

public class TestString {

    public static void main(String [] args)
    {
        String s1=new String("test");                   //创建2个对象，一个Class(常量池)里 和一个堆内存里面
        String s2="test";                                       //创建0个对象，s2指向pool里面的"test"对象
        String s3="test";                                       //创建0个对象,指向s2指想pool里面的那个对象
        String s4=s2;                                           //创建0个对象,指向s2,s3指想pool里面的那个对象
        String s5=new String("test");                   //创建1个对象在堆里面，注意，与s1没关系

        System.out.println(s2=="test");                         //true s2=="test"很明显true
        System.out.println(s2==s3);                             //true,因为指向的都是pool里面的那个"test"
        System.out.println(s2==s4);                             //true,同上,那么s3和s4...:)
        System.out.println(s1==s5);                             //false,很明显,false
        System.out.println(s1==s2);                             //false,指向的对象不一样,下面再说
        System.out.println(s1=="test");                         //false, s1指向堆内存里的对象，"test"是在常量池里的对象
        System.out.println(s1.equals("test"));                  //true, 比较字符串是否一样，而不是对象

        System.out.println("---------------");

        s1=s2;
        System.out.println(s1=="test");                         //true,s1=s2，即s1重新指向常量池里的对象

        System.out.println("---------------");

        String str= "Hello ";                                   //编译的时候这个被优化，和下面一行直接一起变成 String str = "Java "
        str= "Java ";
        String str1= "Hello ";
        System.out.println(str==str1);


        //栈 s1,s2,s3           常量池: "china"      堆 new String("china") new String("china") new String("china")
    }
}