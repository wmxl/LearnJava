
import java.lang.Math;


public class TestRandom {

    public static void main(String[] args) {
        int n = 4, m = 7;
        for (int i = 0; i < 10; i++) {
//            得到n ~ m 的随机数,（n,m都包括），  大数 - 小数 +1
            int r = (int) (Math.random() * (m - n + 1)) + n;
            System.out.println(r);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
//            得到1 ~ n 的随机数,（1,n都包括），
            int r1 = (int) (Math.random() * n) + 1;
            System.out.println(r1);
        }
        System.out.println();

        for (int i = 0; i < 10; i++) {
//            用Math类的random()方法产生一个字符，若该字符是一个大写英文字母，则输入 "Yes!"，否则输出“NO”
            char ch = (char) (Math.random() * 128);
            System.out.print(ch);
            if (ch >= 'A' && ch <= 'Z')
                System.out.println("   Yes!");
            else
                System.out.println("   No!");
        }
    }
}
