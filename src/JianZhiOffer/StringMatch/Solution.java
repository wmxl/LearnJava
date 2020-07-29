package JianZhiOffer.StringMatch;

public class Solution {

    public boolean match(char[] str, char[] pattern) {
        System.out.println(str);
        System.out.println(pattern);

        if(pattern.length == 0){
            if(str.length == 0)return true;
            else return false;
        }
        if(pattern.length > 1)
            if(pattern[0] == '.' && pattern[1] == '*'){
                for(int i =1; i < str.length-1;i++){
                    if(str[i] != str[i+1]) return false;
                }
                return true;
            }

        if (str.length == 0) {
            for (int i = pattern.length - 1; i >= 0; i--) {
                if (pattern[i] == '*') {
                    i--;
                    continue;
                }
                return false;
            }
        }
        int ch2;
        for (int i = pattern.length - 1, ii = str.length - 1; i >= 0 && ii >= 0; i--, ii--) {
            if (pattern[i] == '.') {
                System.out.println(i);
                System.out.println(ii);
                if(i > 0 && ii ==0) return false;
                if(i == 0 && ii >0) return false;
                continue;
            }
            if (pattern[i] == '*') {
                ch2 = pattern[i - 1];

                if (ch2 == '.') {
                    char ch3 = str[ii];
                    int cntP = 0;
                    for (int j = i - 2; j >= 0; j--) {
                        if (pattern[j] != ch3) break;
                        cntP++;
                    }
                    int cntS = 0;
                    for (int j = ii; j >= 0; j--) {
                        if (str[j] != ch3) break;
                        cntS++;
                    }
                    if (cntS >= cntP) {
                        i -= (cntP + 2);
                        ii -= cntS;
                        System.out.println("cntS = " + cntS + ", cntP = " + cntP);
                        System.out.println("i = " + i + ", ii = " + ii);

                        if(i < 0 && ii >= 0) return false;
                        if(i >= 0 && ii < 0) return false;

                        i++;
                        ii++;
                        continue;

                    } else {
                        return false;
                    }

                } else {
                    int cntP = 0;
                    for (int j = i - 2; j >= 0; j--) {
                        if(pattern[j]== '*') {
                            cntP++;
                            cntP++;
                            j--;continue;

                        }
                        if (pattern[j] != ch2) break;
                        cntP++;
                    }
                    int cntS = 0;
                    for (int j = ii; j >= 0; j--) {
                        if (str[j] != ch2) break;
                        cntS++;
                    }
                    if (cntS >= cntP) {
                        i -= (cntP + 2);
                        ii -= cntS;
                        System.out.println("cntS = " + cntS + ", cntP = " + cntP);
                        System.out.println("i = " + i + ", ii = " + ii);
//                        System.out.println(pattern[i] + " " + str[ii]);

                        if(i < 0 && ii >= 0) return false;
                        if(i >= 0 && ii < 0) return false;


                        i++;
                        ii++;
                        continue;

                    } else {
                        return false;
                    }
                }
            }
            if (pattern[i] != str[ii]) return false;
            if(i > 0 && ii == 0) return false;
            if(i == 0 && ii > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.match("aaa".toCharArray(), "ab*a*c*a".toCharArray()));
        System.out.println(solution.match("abaaa".toCharArray(), "ab*a*".toCharArray()));

    }
}
