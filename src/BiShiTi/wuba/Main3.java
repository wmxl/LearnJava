package BiShiTi.wuba;

import java.util.Scanner;


public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int pos = s.indexOf("@");
        String[] mask = {"M", "A", "S", "K"};
        int len = mask.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pos - 1; i++) {
            sb.append(s.charAt(i));
            sb.append(mask[i % len]);
        }
        sb.append(s.substring(pos - 1, s.length()));
        String ans = sb.toString();
        System.out.println(ans);
    }
}