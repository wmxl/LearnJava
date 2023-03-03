import java.util.HashMap;

public class ShallowCopyAndDeepCopy {
    public static void main(String[] args) {
        HashMap map1 = new HashMap();
        map1.put("aa","bb");
        HashMap map2 = map1;
        map1.put("aa","cc");
        System.out.println(map2.get("aa"));

    }
}
