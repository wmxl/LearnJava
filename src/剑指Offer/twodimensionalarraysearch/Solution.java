package 剑指Offer.twodimensionalarraysearch;
//AC， 每行用二分，结果也没用提升速度
public class Solution {
    public boolean Find(int target, int [][] array) {
        int h = array.length;
        int w = array[0].length;
        if(w == 0 || h == 0) return false;

        for (int i = 0; i < array.length; i++) {
            int min  = 0, max = w - 1;
            while (min <= max){
                if(target == array[i][(min+max)/2]){
                    return true;
                }else if (target < array[i][(min+max)/2]){
                    max = (min+max)/2 - 1;
                }else {
                    min = (min+max)/2 + 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] nn = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        int[][] nm = {
                {1,2},
                {7,9},
                {11,39},
                {40,44},
                {55,56}
        };
        int[][] nm2 = {
                {1,2,6,9, 90,233},
        };
        int[][] nm1 = {
                {1},
                {7},
                {11},
                {40},
                {55}
        };
      System.out.println(""+ 7 + new Solution().Find(7, nn));
      System.out.println(""+ 14 + new Solution().Find(14, nn));
      System.out.println(""+ 1 + new Solution().Find(1, nm1));
      System.out.println(""+ 7 +new Solution().Find(7, nm1));
      System.out.println(""+ 40 +new Solution().Find(40, nm1));
      System.out.println(""+ 90 +new Solution().Find(90, nm2));//     System.out.println(""+ 45 +new Solution().Find(45, nn));
      System.out.println(""+ 1 +new Solution().Find(1, nm2));
      System.out.println(""+ 38 +new Solution().Find(38, nm2));
      System.out.println(""+ 6 +new Solution().Find(6, nm2));


    }
}
