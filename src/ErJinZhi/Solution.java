package ErJinZhi;

import java.util.function.BinaryOperator;

public class Solution {
    //在写一个按位与的版本

    //二进制字符串相加
    String BinaryStrPlus(String s1, String s2){
        StringBuffer sb1 = new StringBuffer(s1);
        sb1.reverse();
        StringBuffer sb2 = new StringBuffer(s2);
        sb2.reverse();
        StringBuffer sb3 = new StringBuffer();

        int cnt = 0;
        while(cnt < 10){
            StringBuffer sb4 = new StringBuffer();
            cnt++;
            System.out.println("cnt : " + cnt);

            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            sb3 = new StringBuffer();
            int len = sb1.length() > sb2.length() ? sb1.length():sb2.length();
            for(int i = 0; i < len; i++){
                System.out.println("i = " + i);
                if(i >= sb1.length()){
                    sb3.append(sb2.charAt(i));
                    sb4.append('0');
                }
                else if(i >= sb2.length()){
                    sb3.append(sb1.charAt(i));
                    sb4.append('0');
                }else {
                    char a = sb1.charAt(i);
                    char b = sb2.charAt(i);
                    int temp = a -'0' + b - '0';
                    System.out.println("temp: " + temp);
                    if(temp > 1){
                        sb3.append('0');
                        sb4.append('1');
                    }
                    else{
                        sb3.append((char)(temp + '0'));
                        sb4.append('0');
                    }
                }
                System.out.println("sb3: "+sb3.toString());
            }
            boolean flag = true;
            for(int i = 0; i < sb4.length(); i++){
                if(sb4.charAt(i) == '1') flag = false;
            }
            if(flag) break;

            sb1 = new StringBuffer(sb3);
            sb2 = new StringBuffer(sb4);
            sb2.insert(0,"0");

        }


        System.out.println("--------------------");
        String ans = sb3.reverse().toString();
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "1011";
        String str2 = "110";
        System.out.println("--------------------");
        System.out.println(new Solution().BinaryStrPlus(str1,str2));
    }
}
