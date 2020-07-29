package wmxlUtils;

public class StringUtils {

        public static int compareTest(String s1, String s2){
            int n = 0;
            return compareTest(s1, s2, n);
        }

        public static int compareTest(String s1, String s2, int n){
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    for(int j = i; j < i + n && j < s1.length(); j++){
                        System.err.print(s1.charAt(j));
                        if(j == i + n -1 || j == s1.length() - 1)
                            System.err.println("\n<===>");
                    }
                    for(int j = i; j < i + n && j < s2.length(); j++){
                        System.err.print(s2.charAt(j));
                        if(j == i + n -1 || j == s2.length() - 1)
                            System.err.println("");
                    }
                    return i;
                }
            }
            return 0;
        }



}
