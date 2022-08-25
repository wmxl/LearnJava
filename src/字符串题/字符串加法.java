package 字符串题;

public class 字符串加法 {
    String plus(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 < len2){
            String t = s1;
            s1 = t;
            t = s2;
        }
        //StringBuffer sb1 = new StringBuffer(s1);
        //sb1 = sb1.reverse();
        //StringBuffer sb2 = new StringBuffer(s2);
        //sb2 = sb2.reverse();

        int i = s1.length()-1, j = s2.length()-1, jin = 0;
        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        while(j >= 0){
            char a = s1.charAt(j);
            char b = s2.charAt(j);
            int c = (a - '0') + (b - '0') + jin;
            jin = c > 9 ? 1 : 0;
            c = c % 10;
            sb.append(c);
            j--;
            i--;
        }
        while(i >= 0){
            int c = jin + s1.charAt(i) - '0';
            jin = c > 9 ? 1 : 0;
            c = c % 10;
            sb.append(c);
            i--;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        System.out.println(new 字符串加法().plus("123","456"));
        System.out.println(new 字符串加法().plus("126","456"));
        System.out.println(new 字符串加法().plus("1126","456"));
    }
}
