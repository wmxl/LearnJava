package BiShiTi.HuanJuShiDai;
import java.util.*;
import java.lang.Math;
public class Main {
    public static int[] findDiagonalOrder(int[][] ma)
    {
        if (ma.length == 0) return new int[0];
        int m = ma.length;      // 待处理的矩阵有M行、N列
        int n = ma[0].length;
        int[] result = new int[m * n];  // 用来存放遍历的结果
        int r = 0, c = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = ma[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) { // 元素在最后一列，往下走
                    r++;
                } else if (r == 0) { // 元素在第一行，往右走
                    c++;
                } else { // 其他情况，往右上走
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) { //元素在最后一行，往右走
                    c++;
                } else if (c == 0) { // //元素在第一列，往下走
                    r++;
                } else { //其他情况，往左下走
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[] ans = findDiagonalOrder(a);
        for(int i : ans) System.out.println(i);
        System.out.println();

}}
/*
3
1 2 3
4 5 6
7 8 9
 */