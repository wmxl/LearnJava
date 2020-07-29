package MianShi;

public class IpConvert {
    static String ip = "25525511135";

    public static void dfs(int n, int a[], int len) {
        if (n == 4) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += a[i];
            }
            if (sum == len) {
                String s = convert(a, ip);

            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            a[n] = i;
            dfs(n + 1, a, len);
        }
    }

    public static String convert(int[] a, String ip) {
        StringBuffer sb = new StringBuffer();
        int j = 0, k = 0;
        for (int i = 0; i < ip.length(); i++) {
            sb.append(ip.charAt(i));
            if (k == a[j] - 1) {
                sb.append(".");
                j++;
                k = 0;
                k--;
            }
            k++;
        }
        if (isLegal(ip))
            System.out.println(ip);
        return sb.toString();
    }

    public static boolean isLegal(String ip) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == '.') {
                int a = Integer.valueOf(sb.toString());
                if (a > 255)
                    return false;
                else
                    sb = new StringBuffer();
                continue;
            }
            sb.append(ip.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] f = new boolean[4];
        int[] a = new int[4];

        int len = ip.length();
        dfs(0, a, len);

    }
}
