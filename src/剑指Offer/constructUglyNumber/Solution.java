package 剑指Offer.constructUglyNumber;

import java.util.Arrays;

public class Solution {
    static public int min3(int x, int y, int z){
        x = x < y ? x : y;
        x = x < z ? x : z;
        return x;
    }
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;

        int x = 1, y = 1, z = 1, min;
        int[] res = new int[index+1];
        res[1] = 1;
        for(int i = 2; i <= index; i++){
            min =  min3(res[x] * 2, res[y] * 3, res[z] * 5);
            res[i] = min;
            if(res[x] * 2 == min) x++;
            if(res[y] * 3 == min) y++;
            if(res[z] * 5 == min) z++;
        }
        System.out.println(Arrays.toString(res));
        return res[index];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.GetUglyNumber_Solution(35));

    }
}
