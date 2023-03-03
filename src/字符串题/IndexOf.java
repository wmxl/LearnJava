package 字符串题;

public class IndexOf {

    public int indexOf(String s, String t){
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (j < t.length()){
                if(i == s.length()) return -1;
                if(s.charAt(i) == t.charAt(j)){
                    i++; j++;
                }else {
                    i -= j;
                    break;
                }
                if(j == t.length()) return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new IndexOf().indexOf("ababaaa", "a1baa"));
    }
}
