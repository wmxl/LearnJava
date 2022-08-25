package 剑指Offer.二维数组中的查找;

public class Solution {

    /**
     * 法1：对于每行用二分搜索
     */
    boolean binarySearch(int target, int [] arr) {
        int h = arr.length - 1, l = 0;

        while(l <= h){
            int m = (l + h)/2;
            if(target < arr[m]){
                h = m - 1;
            }else if(arr[m] < target){
                l = m + 1;
            }else return true;
        }
        return false;
    }
    public boolean Find1(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].length != 0 && target < array[i][0])
                return false;
            if(binarySearch(target, array[i])) return true;
        }
        return false;
    }

    /**
     * 法2：dfs
     */
    int t;
    boolean ans = false;
    boolean[][] v;
    public void dfs(int x, int y, int[][] arr) {
        if(ans) return;
        if(x >= arr.length || y >= arr[0].length) return;
        if(v[x][y]) return;
        if(arr[x][y] == t){
            ans = true;
            return;
        }
        if(arr[x][y] < t){
            dfs(x, y + 1, arr);
            dfs(x + 1, y, arr);
        }
        v[x][y] = true;
    }
    public boolean Find2(int target, int [][] array) {
        if(array.length == 0) return false;
        if(array.length == 1 && array[0].length == 0) return false;
        this.t = target;
        v = new boolean[array.length][array[0].length];
        dfs(0, 0, array);
        return ans;
    }

    /**
     * 法3：从左下角 or 右上角开始移动
     */
    public boolean Find(int target, int[][] array) {
        int row = array.length - 1, col = 0; //初始点必须选左下角 or 右上角
        while (row >= 0 && col <= array[0].length - 1) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])
                col++;
            else
                row--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {0,1,3,5,9, 11, 99, 1345, 9239234};
        int[][] a1 = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
        };

        System.out.println(new Solution().Find(15, a1));
    }
}