package BiShiTi.XiaoHongShu;

import java.util.Scanner;

public class Main2 {
    public static StringBuffer Tuige(StringBuffer sb) {
        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(c == '<'){
                    flag = true;
                    if(i != 0){
                        if(sb.charAt(i-1) == ')' || sb.charAt(i-1) == '('){
                            sb.delete(i, i+1);
                            break;
                        }
                    }
                    try{
                        sb.delete(i-1, i+1);
                    }catch (Exception e){
                        sb.delete(i, i+1);
                    }
                    break;
                }
            }
//            System.out.println(sb);
        }
        return sb;
    }
    public static StringBuffer Kuohao(StringBuffer sb) {
        int st = 0, ed;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(c == '('){
                    flag = true;
                    st = i;
                }
                if(c == ')'){
                    ed = i;
                    sb.delete(st, ed+1);
                    break;
                }
            }
        }
        return sb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s  = sc.next();
            StringBuffer sb = new StringBuffer(s);

            sb = Kuohao(sb);
            System.out.println(Tuige(sb));
        }
    }
}
/*
a<<b((c)<)
aaa(aa)
ab(abc)<d
 */