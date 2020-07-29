package BiShiTi.HuaWei;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String str = Integer.toBinaryString(n);

            StringBuffer sb1 = new StringBuffer(str);
            sb1.reverse();
            str = sb1.toString();

            int sum = 0, index = -1;
            boolean flag = false;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '1'){
                    StringBuffer sb = new StringBuffer();
                    for (int j = i; j < str.length(); j++) {
                        sb.append(str.charAt(j));
                        if(j == i + 2){
                            if(sb.toString().equals("101")){
                                if(!flag){
                                    index = i;
                                    flag = true;
                                }
                                sum++;
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println(sum + " " + index);
        }
    }
}
/*
21
31
 */