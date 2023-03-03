package 字符串题.正则表达式匹配;


//    // pattern
//// 单个字符
//// . 任意一个字符
//// * 前一个字符的0-n个
//// match:
//// abc       abc, a.c, a*b*c*, .*, ...
//// .* "" . .. ... ....
//
//    // abc a.*bc
//// abc ab*bc
//// abbc ab*bc
public class Solution {
    boolean matchStr(char[] s, char[] p, int i, int j){
        if(i == s.length && j == p.length) return true;
        if(j == p.length) return false;

        if(j+1 < p.length && p[j+1] == '*'){
            if(i < s.length && (s[i] == p[j] || p[j] == '.'))
                return matchStr(s,p, i+1, j) || matchStr(s,p, i, j+2);
            else
                return matchStr(s,p, i, j+2);
        }else{
            if(i < s.length && (s[i] == p[j] || p[j] == '.'))
                return matchStr(s,p, i+1, j+1);
            else
                return false;
        }
    }
    public boolean match(char[] str, char[] pattern) {
        return matchStr(str,pattern,0,0);
    }

    public static void main(String[] args) {
        char[] str = "abc".toCharArray();
        char[] pattern = "ab*bc".toCharArray();
        System.out.println(new Solution().match(str, pattern));
    }
}