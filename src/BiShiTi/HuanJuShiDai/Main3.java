package BiShiTi.HuanJuShiDai;

import java.util.*;
import java.lang.Math;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] num = str.split(" ");
        String ind = num[num.length-1];
        int xiapiao = findxiaop(num, 0, num.length-2, ind);
        if(xiapiao == -1){
            System.out.println(xiapiao);
        }else{
            int temp = xiapiao;
            while(temp < num.length-2){
                if(num[temp].equals(num[temp + 1])){
                    temp ++;
                }else{
                    break;
                }
            }
            System.out.println(temp);
        }
    }
    public static int findxiaop(String[] num, int left, int right, String ind){
        int xia = -1;
        if(left <= right){
            int mid = (left+right)/2;
            if(Integer.valueOf(num[mid]) < Integer.valueOf(ind)){
                xia = findxiaop(num, mid+1, right, ind);
            }
            if(Integer.valueOf(num[mid]) > Integer.valueOf(ind)){
                xia = findxiaop(num, left, mid-1, ind);
            }
            if(Integer.valueOf(num[mid]) == Integer.valueOf(ind)){
                xia = mid;
            }
        }
        return xia;
    }
}
/*
3 4 5 7 7 8 8 8 9 8
 */