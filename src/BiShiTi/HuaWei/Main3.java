package BiShiTi.HuaWei;

import java.util.Scanner;

public class Main3 {
    public static boolean operate(char a, char b, char c){
        boolean ans = false;
        boolean A, B;
        if(a == '1')A = true;
        else A = false;
        if(b == '1')B = true;
        else B = false;
        switch (c){
            case '&':
                ans = A & B;
                break;
            case '|':
                ans = A | B;
                break;
            default:
                ans = false;
        }
        return ans;
    }
    public static boolean operate(char a, char c){
        boolean A;
        if(a == '1')A = true;
        else A = false;
        return !A;
    }
    public static String solution(StringBuffer sb){
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch  == '!'){
                if(sb.charAt(i+1) == '0'){
                    sb.replace(i,i+2,"1");
                }else {
                    sb.replace(i,i+2,"0");
                }
            }
        }
        boolean ans = false;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '&'){
                ans = operate(sb.charAt(i-1), sb.charAt(i+1), '&');
                if(ans)
                    sb.replace(i-1,i+2,"1");
                else
                    sb.replace(i-1,i+2,"0");
                i--;
//                System.out.println(sb.toString());
            }
        }
        boolean ans2 = false;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch == '1'){
                ans2 = true;
                break;
            }
        }
        if(ans | ans2) return "1";
        else return "0";
    }
    public static boolean hasParentheses(StringBuffer sb){
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(')
                return true;
        }
        return  false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            StringBuffer sb = new StringBuffer(str);
            boolean flag = false;
            while (hasParentheses(sb)){
                for(int i = 0; i < sb.length(); i++){
//                    System.out.println("i = " + i);
                    if(sb.charAt(i) == '('){
                        StringBuffer innerSb = new StringBuffer();
                        for (int j = i+1; j < sb.length(); j++) {
                            if(sb.charAt(j) == '('){
                                innerSb = new StringBuffer();
                                i = j;
                                continue;
                            }
                            if(sb.charAt(j) == ')'){
//                                System.out.println(i + " " + j);
//                                System.out.println("innerSb = " + innerSb);
                                String s = solution(innerSb);
//                                System.out.println(s);
                                sb.replace(i,j+1, s);
//                                System.out.println(sb);
                                break;
                            }
                            innerSb.append(sb.charAt(j));
                        }
                    }
                }
            }
            System.out.println(solution(sb));
        }
    }
}
/*
!0&1|0
(0&1)|(1&1)
0&(0&1)&(1&1)
0&(0&1)&((1|0)&1)
!(0&(0&1)&((1|0)&1))
(0&(0&1)&1)&1

1|(1&0)
1&0|0&1
!0&1|0
((!0&1))|0

 */