package JinZhiZhuanHua;

import java.util.Stack;

public class Main {
    //十进制转 -> 任意进制
    public static String convert(int n, int base){
        char[] digit = "0123456789ABCDEF".toCharArray();
        Stack<Character> s = new Stack<>();
        boolean negative = false;
        if(n < 0){
            negative = true;
            n = -n;
        }
        while(n > 0){
            s.push(digit[n % base]);
            n /= base;
        }
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        String ans = sb.toString();
        if(negative) ans = "-" + ans;
        return ans;
    }
    //任意进制 -> 转十进制
    public static int convert(String num, int base){
        boolean negative = false;
        if(num.charAt(0) == '-'){
            negative = true;
            num = num.substring(1, num.length());
        }
        int ans = 0,  exponent = 0;;
        for (int i = num.length()-1; i >= 0 ; i--) {
            char n = num.charAt(i);
            ans += (n-'0') * Math.pow(base, exponent++);
        }

        if(negative) ans = -ans;
        return ans;
    }
    public static void main(String[] args) {
        int n = -5;
        System.out.println(convert(n, 2));

        String num = "-101";
        System.out.println(convert(num, 2));
    }
}
