package StringProblems;

public class IndexOf {
    public int strStr(String s, String t) {
        if (t.length() == 0) return 0;

        for (int i = 0; i < s.length();i++) {
            int j = 0;
            while (j < t.length()) {
                if (i >= s.length()) return -1;
                if (t.charAt(j) == s.charAt(i)) {
                    if (j == t.length() - 1) return i - j;
                    i++;
                    j++;
                } else {
                    i -= j;
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new IndexOf().strStr("ababaaa", ""));
    }
}
