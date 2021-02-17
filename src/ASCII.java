

public class ASCII {


    public static void main(String[] args) {

        for (int i = 0; i < 55; i++) {
            char a = (char) ('0' + i);
            System.out.print(a);
            System.out.printf("  ");
        }
        System.out.println();
        for (int i = 0; i < 55; i++) {
            int a =  '0' + i;
            System.out.print(a);
            System.out.printf(" ");

        }
        System.out.println();

    }
}