package DataStructrue.FastPointAndSlowPoint;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public void reverseString(char[] s) {
        char t;
        for(int i = 0, j = s.length -1; i < s.length/2; i++,j--){
//            System.out.println("s[i] = " + s[i]);
//            System.out.println("s[j] = " + s[j]);
             t =  s[i];
             s[i] = s[j];
             s[j] = t;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] s = {'a','b','c','d','e'};
        char[] s1 = {'a','b','c','d'};
        solution.reverseString(s);
        solution.reverseString(s1);
        System.out.println(s);
        System.out.println(s1);
    }
}
