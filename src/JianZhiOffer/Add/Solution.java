package JianZhiOffer.Add;

public class Solution {
    public int Add(int num1,int num2) {
        int nextNum1;
        while(num2 != 0){

            nextNum1 = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = nextNum1;
            System.out.println("num1 " + Integer.toBinaryString(num1));
            System.out.println("num2 " + Integer.toBinaryString(num2));
        }

        return num1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Add(2, 3));
        System.out.println(2|3);
    }

}
