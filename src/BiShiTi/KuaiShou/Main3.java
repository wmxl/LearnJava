package BiShiTi.KuaiShou;

        import java.util.*;

public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String useless = sc.nextLine();
        for(int i = 0; i < m; i++){
            String s = sc.nextLine();
            String[] versions = s.split(" ");
            System.out.println(com(versions[0],versions[1]));
        }
    }
    public static boolean com(String v1, String v2) {
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        int len = Math.max(s1.length, s2.length);
        for (int i = 0; i < len; i++) {
            int first = i < s1.length ? Integer.valueOf(s1[i]) : 0;
            int second = i < s2.length ? Integer.valueOf(s2[i]) : 0;
            if (first < second) return true;
            else if (first > second) return false;
        }
        return false;
    }
}
/*
2
6.6.6 6.6.7
1 1.0


3, 4.3.5.4, 2.10.3, 2.4
 */