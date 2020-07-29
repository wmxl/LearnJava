package JianZhiOffer.twodimensionalarraysearch;
//AC 185ms
// 如果把每行每列都是顺序递增用上，可以把时间优化到，然而提交结果显示n*n/4 和 n*n 貌似没区别
// 这题纯暴力就够了，一点也不用优化
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int maxW = array[0].length;
        int maxH = array.length;
        System.out.println("maxH = " + maxH);
        System.out.println("maxW = " + maxW);
        if( maxH == 0 || maxW ==0)return false;

        if(target < array[0][0])
            return false;
        if(target > array[maxH-1][maxW-1])
            return false;

        for (int i = 0; i < maxH; i++) {
            if(array[i][0] > target){
                return false;
            }
            for (int j = 0; j < maxW; j++) {
                if(array[i][j] == target) return true;
                else if(array[i][j] > target){
                    maxW = j;
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
                {}
        };
        System.out.println(""+ 7 + new Solution1().Find(7, nn));
        System.out.println(""+ 0 + new Solution1().Find(0, nm1));
        System.out.println(""+ 1 + new Solution1().Find(1, nm1));
        System.out.println(""+ 7 +new Solution1().Find(7, nm1));
        System.out.println(""+ 40 +new Solution1().Find(40, nm1));
    }
}
