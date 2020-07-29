package Enum;

public enum EnumTest {
    MON, TUE, WED, THU, FRI, SAT, SUN;


    public static void main(String[] args) {
//        System.out.println(EnumTest); //报错
        System.out.println(EnumTest.valueOf("MON"));
        System.out.println(EnumTest.MON);
        System.out.println(EnumTest.values());
        for (EnumTest e : EnumTest.values()){
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("----------------我是分隔线------------------");

        EnumTest test = EnumTest.TUE;
        switch (test) {
            case MON:
                System.out.println("今天是星期一");
                break;
            case TUE:
                System.out.println("今天是星期二");
                break;
            // ... ...
            default:
                System.out.println(test);
                break;
        }
    }
}