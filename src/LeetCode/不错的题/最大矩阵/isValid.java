package LeetCode.不错的题.最大矩阵;

import java.util.Stack;

public class isValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else if(!stack.isEmpty() && stack.peek() == '(' && c == ')'){
                stack.pop();
            }else if(!stack.isEmpty() && stack.peek() == '[' && c == ']'){
                stack.pop();
            }else if(!stack.isEmpty() && stack.peek() == '{' && c == '}'){
                stack.pop();
            }else return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public boolean isValid2(String s) {
        if(s.length() == 0) return true;
        StringBuffer sb = new StringBuffer(s);
        return isV(sb);
    }
    public boolean isV(StringBuffer sb) {
        if(sb.length() == 0) return true;
        int len = sb.length();
        for (int i = 0; i < sb.length()-1; i++) {
            char c = sb.charAt(i);
            char d = sb.charAt(i + 1);
            if(c == '(' && d == ')' || c == '[' && d == ']' || c == '{' && d == '}'){
                sb.delete(i,i+2);
            }
        }
        if(len == sb.length()) return false;
        return isV(sb);
    }


    public static void main(String[] args) {
        System.out.println(new isValid().isValid("()"));
    }
}
