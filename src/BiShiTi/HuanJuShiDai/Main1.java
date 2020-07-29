package BiShiTi.HuanJuShiDai;
import java.util.*;
import java.lang.Math;
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        String s = sc.nextLine();
        if(s.length() == 1){
            n = m = Integer.valueOf(s);
        }else{
            String[] ss = s.split(" ");
            m = Integer.valueOf(ss[0]);
            n = Integer.valueOf(ss[1]);
        }
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int [] result = new int[m * n];
        int flag = 0;
        for (int i = 0; i <= m + n; i++) {
            if(i % 2 == 0){
                for (int j = m; j >=0 ; j--) {
                    if(j >= 0 && j < m && i - j >= 0 && i - j < n)
                        result[flag++] = a[j][i - j];
                }
            }else {
                for (int j = 0; j <= m; j++) {
                    if(j >= 0 && j < m && i - j >= 0 && i - j < n)
                        result[flag++] = a[j][i - j];
                }
            }
        }
        if(m == n && m == 0)
        {

        }else{
            for (int i = 0; i < m*n; i++) {
                System.out.print(result[i]);
            }
        }

    }

}
/*
3
1 2 3
4 5 6
7 8 9
3 3
1 2 3
4 5 6
7 8 9
3 4
1 2 3 11
4 5 6 11
7 8 9 11
 */