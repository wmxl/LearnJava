package 剑指Offer.jinZhiZhuanHua;
//ac 顺便把十进制转2进制字符串自己实现了，
//负数转补码字符串：先把对应的正数的二进制得到，然后从右边数，遇到第一个1，不管，后面的数字全都取反
public class Solution {
    public int NumberOf1(int n) {
//        if(n == -2147483648) return 1;
        int r, cnt= 0, flag = 0;
        StringBuffer binary = new StringBuffer();
        if(n < 0) {
            n = -n;
            flag = 1;
        }
        for (; ; ) {
            r = n % 2;
            binary.append(r);
            n = n / 2;
            if(n == 0)break;
        }
        int a = 32 - binary.length();
        for (int i = 0; i < a; i++) {
            binary.append('0');
        }

        System.out.println(binary);
        binary.reverse();
        System.out.println(binary);

        if(flag == 1){
            for (int i = binary.length()-1; i >= 0; i--) {
                if(binary.charAt(i) == '1' && flag == 1) {
                    flag = 2;
                    continue;
                }
                if(flag == 2){
                    if(binary.charAt(i) == '1')
                        binary.setCharAt(i,'0');
                    else
                        binary.setCharAt(i,'1');
                }
            }
        }
        System.out.println(binary);//得到二进制字符串

        for (int i = 0; i < binary.length(); i++) {//得到有多少个1
            if(binary.charAt(i) =='1') cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(-2147483648));
    }

}
