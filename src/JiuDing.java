import java.util.*;

public class JiuDing {

    boolean checkIfExist(int[] a){
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));

        int k;
        for (k = 0; k < a.length; k++) {
            if(a[k] >= 0) break;
        }

        int i = 0, j = 1;
        while(i < k && j < k){
            if(a[i] == a[j] * 2){
                // System.out.println(i + " ||" +j);
                return true;
            }else if(a[i] > a[j] * 2){
                j++;
            }else if(a[i] < a[j] * 2){
                i++;
            }
        }

        i = k; j = k + 1;
        while(i < a.length && j < a.length){
            if(a[j] == a[i] * 2){
                // System.out.println(i + " |" +j);
                return true;
            }
            if(a[j] > a[i] * 2){
                i++;
            }
            if(a[j] < a[i] * 2){
                j++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] a= {-2,0,10,-19,4,6,-8};
        System.out.println(new JiuDing().checkIfExist(a));
    }
}
