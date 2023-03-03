package 字符串题.字符流中第一个不重复的字符;

public class Solution {

    boolean judge(char[] s){

        int cnt = 0, num = 0, flag = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] >= '0' && s[i] <= '9'){
                cnt++;
                num = num * 10 + (s[i] - '0');
                if(num > 255 || cnt > 3) return false;
            }else if(s[i] == '.' || i == s.length-1){
                flag++;
                if(cnt == 0 || flag > 3) return false;
                cnt = 0;
                num = 0;
            }else {
                return false;
            }
        }
        if(flag != 3) return false;
        return true;
    }

    public static void main(String[] args) {
        String str = "0.100.0.555";
        char[] s = str.toCharArray();
        System.out.println(new Solution().judge(s));
    }

}
