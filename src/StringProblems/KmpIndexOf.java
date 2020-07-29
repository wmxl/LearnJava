package StringProblems;

import java.util.Arrays;

public class KmpIndexOf {
    public int[] generateNext(String t){
        int[] next = new int[t.length()];
        next[0] = -1;
        int k;
        for (int i = 1; i < next.length; i++) {
            k = next[i-1];
//            System.out.println("i = " + i);
            while (k != -1){
                if(t.charAt(i-1) == t.charAt(k)){
//                    System.out.println("t.charAt(i-1) = " + t.charAt(i-1));
//                    System.out.println("t.charAt(k) = " + t.charAt(k));
                    next[i] = k + 1;
                    break;
                }else {
                    k = next[k];
                }
            }
        }
        return next;
    }

    public int kmp(String s, String t) {

        if (t.length() == 0) return 0;
        if(s.length() == 0) return -1;

        int[] next = generateNext(t);
        System.out.println("next = " + Arrays.toString(next));
        int i = 0, j = 0;
        while (i < s.length()) {
//            System.out.println("i = " + i);
            if (j == -1 || t.charAt(j) == s.charAt(i)) {

                if(j == t.length()-1) return i - j;
//                System.out.println("j = " + j);
                i++;
                j++;
            } else {
//                System.out.println("j = " + j);
                j = next[j];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "abacbbcbab";
        String t = "cba";

//        int[] next = new KmpIndexOf().generateNext("abacbb");
        int n = new KmpIndexOf().kmp("mississippi","issip");
        System.out.println(n);
    }
}
