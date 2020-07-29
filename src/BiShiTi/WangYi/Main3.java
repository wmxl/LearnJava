package BiShiTi.WangYi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static int findnum(String s){
        int len = s.length();
        ArrayList<Integer> l = new ArrayList<>();
        int maxlen = 0;
        int curlen = 0;
        l.add(-1);
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) != 'N'){
                l.add(i);
            }
        }
        l.add(len);
        if(l.size()<= 4){
            return len;
        }else {
            for (int j = 3; j < l.size(); j++) {
                curlen = l.get(j) - l.get(j - 3) -1;
                if(curlen > maxlen){
                    maxlen = curlen;
                }
            }
            return maxlen;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String str = sc.next();
            System.out.println(findnum(str));
        }
    }
}
/*
3
NNTN
NNNNGGNNNN
NGNNNNGNNNNNNNNNSNNNN
 */
