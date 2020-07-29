package BiShiTi.KuaiShou;

import java.util.*;

public class Main {
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

    public String getMinVersion(String[] versions) {
        if(versions.length == 0) return "";
        String ans = versions[0];
        for (int i = 1; i < versions.length; i++) {
            if(!com(ans, versions[i])){
                ans = versions[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] versions = s.split(", ");

        System.out.println(new Main().getMinVersion(versions));

    }


}
/*

6.6.6, 6.6.7
1, 1.0


3, 4.3.5.4, 2.10.3, 2.4
 */