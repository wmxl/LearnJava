import java.util.ArrayList;
import java.util.List;
public class SafeLevel2 {
    static public int LastRemaining_Solution(int target) {
        int r = 1;
        while(target >= 2){
            System.out.println("t:" + target);
            if(target == 2){
                System.out.println(2);
                return r*2;
            }
            if(target == 3){
                System.out.println(3);
                return r*3;
            }
            if(target == 4){
                return r * 4;
            }
            if(target>3){
                System.out.println(3);
                target -=3;
                r*=3;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(17));
    }
}