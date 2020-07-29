package JianZhiOffer.ZiFuPaiLie;

import java.util.ArrayList;

public class Solution {
    static char[] chArray = new char[10];
    static boolean v[] = new boolean[10];

    public static void dfs(int n, String str, ArrayList<String> list){
        if(n == str.length()){
            String s1 = new String();
            for (int i = 0; i < str.length(); i++) {
                s1 += chArray[i];
            }
            System.out.println(s1);

            for(int i = 0; i <list.size(); i++){
                if(s1.equals(list.get(i)))
                    return;
            }
            list.add(s1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(!v[i]){
                v[i] = true;
                chArray[n] = str.charAt(i);
                dfs(n+1, str, list);
                v[i] = false;
            }
        }
    }
    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0)
            return new ArrayList<String>();

        ArrayList<String> list = new ArrayList<String>();
        dfs(0, str, list);
        return list;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Permutation("abc"));
    }
}
