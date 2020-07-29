package ACM;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        while(in.hasNext()){
            int n = in.nextInt();
            hm.clear();
            while (n-- > 0){
                String s = in.next();
                if(hm.get(s) == null){
                    System.out.println("OK");
                    hm.put(s, 1);
                }else {
                    int num = hm.get(s);
                    System.out.println(s + num);
                    hm.put(s, num+1);
                }
            }
        }

    }
}
