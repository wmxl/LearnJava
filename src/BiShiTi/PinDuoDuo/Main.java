package BiShiTi.PinDuoDuo;

import java.util.*;

public class Main {
    public static boolean inStr(char c, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) return true;
        }
        return false;
    }

    public static int atleft(char c, String str, StringBuffer sb) {
        if (sb.length() == 1) {
            char b = sb.charAt(0);
            int i;
            for (i = 0; i < str.length(); i++) {
                if(b == str.charAt(i)) break;
            }
            int j;
            for (j = 0; j < str.length(); j++) {
                if(c == str.charAt(j)) break;
            }

            if(i < j) return -1;
            if(i > j) return 1;
            else return 0;
        }else {
            char s = sb.charAt(0);
            char b = sb.charAt(sb.length()-1);
            int left = 0, right = 0;
            for (int i = 0; i < str.length(); i++) {
                if(s == sb.charAt(i)) left = i;
                if(b == sb.charAt(i)) right = i;
            }
            int pos = 0;
            for (int i = 0; i < str.length(); i++) {
                if(c == sb.charAt(i)) pos = i;
            }
            if(pos < left && pos < right) return -1;
            else if(pos > right && pos > left) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] old = new String[n];
        String[] nw = new String[n];
        String uesless = sc.nextLine();
        for (int t = 0; t < n; t++) {
            old[t] = sc.nextLine();
            nw[t] = sc.nextLine();

            String _old = old[t];
            String _nw = nw[t];
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < _old.length(); i++) {
                char c = _old.charAt(i);



                if (inStr(c, _nw)) {
                    System.out.println("d");
                } else if (sb.length() == 0) {
                    System.out.println("l or r");
                    sb.append(c);
                } else if (atleft(c, _nw, sb) == -1) {
                    System.out.println("l");
                } else if (atleft(c, _nw, sb) == 1) {
                    System.out.println("r");
                } else  if(atleft(c, _nw, sb) == 0){
                    System.out.println("error");
                }
            }

        }
    }
}
/*
3
123
3
123
321
45
67

 */