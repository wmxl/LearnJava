import java.util.*;

public class LeetCode {


            public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
                HashMap<String, Integer> map = new HashMap<>();
                for (int i = 0; i < dig.length  ; i++) {
                    int x = dig[i][0];
                    int y = dig[i][1];
                    map.put(x+"_"+y, 1);
                }
        //        System.out.println(map);

                boolean f = true;
                int not = 0;
                for (int i = 0; i < artifacts.length; i++) {
                    f = true;
        //            System.out.println(artifacts[i][0]+ " " + artifacts[i][2]);
        //            System.out.println(artifacts[i][1] + " " + artifacts[i][3]);
                    for (int j = artifacts[i][0]; j <= artifacts[i][2]; j++) {
                        if(!f)break;
                        for (int k = artifacts[i][1]; k <= artifacts[i][3]; k++) {
        //                    System.out.println(j +"_"+k);
                            if(!f)break;
                            if(!map.containsKey(j + "_" + k)){
                                f = false;
                                not ++;
                                break;
                            }
                        }
                    }
                }
                System.out.println("not = " + not);
                return artifacts.length - not;
            }

    public static void main(String[] args) {
        int n1 = 2;
        int[][] artifacts1 = {{0,0,0,0},{0,1,1,1}};
        int[][] dig1 = {{0,0},{0,1}};

        int n = 2;
        int[][] artifacts = {{0,0,0,0},{0,1,1,1}};
        int[][] dig = {{0,0},{0,1},{1,1}};

        LeetCode leetCode = new LeetCode();
        System.out.println(leetCode.digArtifacts(n, artifacts, dig));
    }
}