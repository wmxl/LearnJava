package JianZhiOffer.jinZhiZhuanHua;
//ac
public class Solution1 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (true){
            cnt += (n & 1);
            n = n >>> 1;
            if(n == 0) break;
        }
        return cnt;
    }
    public static void main(String[] args) {
//        System.out.println(-3 & 1);

        int a  =-2147483648;
        int b = a >> 1;
        int c = a>>>1;

//        System.out.println(b);
//        System.out.println(c);
        System.out.println(new Solution1().NumberOf1(a));
    }
}
