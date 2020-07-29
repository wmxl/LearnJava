package BiShiTi.PinDuoDuo;

import java.util.*;

public class Main2 {
    public  static void dfs(String old, String nw, int len, int dep, String s1, String s2, List<String> list){
        if(len == dep){
            if(s2.equals(nw)){
                s1 = s1.substring(0, s1.length()-1);
                list.add(s1);
            }
            return ;
        }
        dfs(old.substring(1), nw, len,dep+1, s1 + "d ", s2, list);
        dfs(old.substring(1), nw, len,dep+1, s1 +"l ", nw.charAt(0) + s2, list);
        dfs(old.substring(1), nw, len,dep+1, s1+"r ", s2+nw.charAt(0) , list);
    }

    public static void cal(String old, String nw, int len){
        List<String > res = new ArrayList<>();
        dfs(old, nw, len,0, "", "", res);
        System.out.println("{");
        for (String s : res){
            System.out.println(s);
        }
        System.out.println("}");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] old = new String[n];
        String[] nw = new String[n];
        String uesless = sc.nextLine();
        for (int t = 0; t < n; t++) {
            old[t] = sc.nextLine();
            nw[t] = sc.nextLine();

            String _old = old[t];
            String _nw = nw[t];

            cal(old[t], nw[t], old[t].length());
        }
    }
}
/*
3
123
3
123
321
45
67

 */