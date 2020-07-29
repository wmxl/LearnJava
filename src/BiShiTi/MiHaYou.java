package BiShiTi;

import java.util.*;
import java.lang.Math;

public class MiHaYou {
    public static char[][] mat;
    public static int m, n;

    static void changeMat(int x1, int y1, int x2, int y2) {
        char t = mat[x1][y1];
        mat[x1][y1] = mat[x2][y2];
        mat[x2][y2] = t;
    }

    static void print() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

//    static void xiaochu() {
//        int count = 1;
//        for(int i = 0; i < n-1; i++){
//            if(a[i][j] == a[i+1][j])
//                count++;
//            else{
//                if(count >= 3){
//                    for(int k = 0; k < count; k++)
//                        a[i-k][j] = 0;
//                }
//                count = 1;
//            }
//        }
//
//
//    }

    static void xiajiang() {
        char[][] newMat = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMat[i][j] = '0';
            }
        }
        int cnt = 0;
        for (int j = 0; j < n; j++)
            for (int i = m - 1; i >= 0; i--) {
                if (mat[i][j] != '0')
                    newMat[cnt++][j] = mat[i][j];
                else
                    continue;
            }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        mat = new char[m][n];

        String useless = sc.nextLine();
        for (int i = 0; i < m; i++) {
            String ss = sc.nextLine();
            for (int j = 0; j < n; j++) {
                mat[i][j] = ss.charAt(j);
            }
        }
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        print();
        changeMat(x1, y1, x2, y2);
        print();
    }
}

/*
4 4
HFCE
GCAC
GFAD
DCBA
3 2 3 3
 */