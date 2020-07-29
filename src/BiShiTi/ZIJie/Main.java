package BiShiTi.ZIJie;

import java.util.Scanner;

public class Main {
    public static class Time{
        int a,b;
        Time(int a, int b){
            this.a = a;
            this.b = b;
        }
        public void set(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static int compare(Time x, Time y) {
        if(x.a == y.a){
            return x.b - y.b;
        }
        return  x.a - y.a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[111], b = new int[111];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        Time end = new Time(A,B);
        for (int i = n-1; i >= 0; i--) {
            int shi = a[i];
            int fen = b[i];
            fen += x;
            if(fen >= 60){
                fen = (fen+60) % 60;
                shi = shi + x/60;
            }

            Time t = new Time(shi, fen);
            if(compare(t, end) <= 0){
                System.out.println(a[i] + " " + b[i]);
                break;
            }
        }
    }
}
/*
3
5 0
6 0
7 0
59
6 59
 */