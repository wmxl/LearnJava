package StringProblems;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0) return "";
        int minLen = 999999;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() == 0) return "";
            minLen = minLen < strs[i].length() ? minLen : strs[i].length();
        }
        System.out.println("minLen = " + minLen);
        StringBuffer sb = new StringBuffer("");
        for (int j = 0; j < minLen; j++) {
            char c = strs[0].charAt(j);
            System.out.println("c = " + c);
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].charAt(j) == c){
                    if(i == strs.length-1){
                        sb.append(c);
                        System.out.println("j = " +j +"tianjia");

                    }
                }else {
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"dog","dosdfsdf","dobasdf"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }
}
