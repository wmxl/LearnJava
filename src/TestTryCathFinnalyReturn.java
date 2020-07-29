/*
结论： 如果
 */

public class TestTryCathFinnalyReturn {
    public static int test(){
        int a = 0;
        try{
            a = 1;
            return a;
        }catch (Exception e){
        }finally {
            a = 3;
            return a;
        }
//        return a;
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
