import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] s = new String[9999];
        String uesless = sc.nextLine(); // 先nextInt(); 再sc.nextLine()的， 循环前一定要加这一行
        for (int i = 0; i < n - 1; i++) {
            s[i] = sc.nextLine();
        }
    }
}
/*
 public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        }
 */