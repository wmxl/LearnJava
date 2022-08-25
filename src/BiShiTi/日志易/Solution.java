package BiShiTi.日志易;


import java.util.*;

public class Solution {

// 192.168.1.1
// | 0 | 0 | 0 | 0 | -> | 192 | 168 | 1 | 1 |
    public int ip2int(String ip1) {
        String ip = "." + ip1;
        int num = 0, n = 0, mul = 1, ans = 0;
        for(int i = ip.length()-1 ; i >= 0; i--){
            char c = ip.charAt(i);
            if(c == '.'){
                ans += num * Math.pow(2,n);
                n += 8;
                num = 0;
                mul = 1;
            }else{
                int a = c - '0';
                mul *= 10;
                num = a * mul + num;
            }
        }
        return ans;
    }

    public int ip2int1(String ip1) {
        String ip = "." + ip1;
        int num = 0, n = 0, mul = 1, ans = 0;
        for(int i = ip.length()-1 ; i >= 0; i--){
            char c = ip.charAt(i);
            if(c == '.'){
                ans += num * Math.pow(2,n);
                n += 8;
                num = 0;
                mul = 1;
            }else{
                int a = c - '0';
                mul *= 10;
                num = a * mul + num;
            }
        }
        return ans;
    }

// pattern
// 单个字符
// . 任意一个字符
// * 前一个字符的0-n个
// match:
// abc       abc, a.c, a*b*c*, .*, ...
// .* "" . .. ... ....
// abc a.*bc
// abc ab*bc
// abbc ab*bc
    boolean matchStr(char[] s, char[] p, int i, int j){
        if(s.length == i && p.length == j) return true;
        if(p.length == j) return false;

        if(j+1 < p.length && p[j+1] == '*'){
            if(i < s.length && (s[i] == p[j] || p[j] == '.')){
                return matchStr(s, p, i+1, j) || matchStr(s, p, i, j+2);
            }else {
                return matchStr(s, p, i, j+2);
            }
        }else {
            if(i < s.length && (s[i] == p[j] || p[j] == '.')){
                return matchStr(s, p, i+1, j+1);
            }else {
                return false;
            }
        }
    }
    public boolean match(char[] str, char[] pattern) {
        return matchStr(str, pattern, 0, 0);
    }

    public static void main(String[] args) {
        char[] str = "abc".toCharArray();
        char[] pattern = "ab*bc".toCharArray();
        System.out.println(new Solution().match(str, pattern));
    }
}
