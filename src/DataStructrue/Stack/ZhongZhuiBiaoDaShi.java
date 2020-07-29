package DataStructrue.Stack;

import java.util.*;
import java.lang.*;

import static java.lang.Character.isDigit;

public class ZhongZhuiBiaoDaShi {
    static Stack<Integer> numStack = new Stack<>();
    static Stack<Character> opStack = new Stack<>();

    static int getPriority(char ch) {
        switch (ch) {
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case '!':
                return 4;
            case '(':
                return 99;
        }
        return 0;
    }

    public static char compare(char stackPeek, char now) {
        if (stackPeek == '(') {
            if(now == ')') return '=';
            else return '<';
        }
        else if (stackPeek == '$' && now == '$') return '=';
        else if (getPriority(stackPeek) >= getPriority(now)) return '>';
        else return '<';
    }

    static int compute(int a, char ch, int b) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return (int) Math.pow((double) a, (double) b);
        }
        return 0;
    }

    static int compute(int a, char ch) {
        switch (ch) {
            case '!':
                return factorial(a);
        }
        return 0;
    }

    public static int factorial(int number) {
        if (number <= 1) return 1;
        else return number * factorial(number - 1);
    }

    static int evaluate(String s) {
        s = s + '$';
        int i = 0;
        opStack.push('$');
        while (!opStack.isEmpty() && i < s.length()) {
            char c = s.charAt(i);
            System.out.println("c = " + c);
            if (isDigit(c)) {
                int num = c - '0';
                if (i > 0)
                    if (isDigit(s.charAt(i - 1))) {
                        int lastNum = numStack.pop();
                        num = lastNum * 10 + num;
                    }
                numStack.push(num);
                i++;
            } else {
                if (compare(opStack.peek(), c) == '<') {
                    System.out.println("<");
                    opStack.push(c);
                    i++;
                } else if (compare(opStack.peek(), c) == '>') {
//                    System.out.print(opStack.peek());
//                    System.out.print(" > ");
//                    System.out.println(c);
                    char ch = opStack.pop();
                    if (ch == '!') {
                        numStack.push(compute(numStack.pop(), ch));
                    } else {
                        int a = numStack.pop();
                        int b = numStack.pop();
                        int d = compute(b, ch, a);
                        System.out.println("a = " + a);
                        System.out.println("b = " + b);
                        System.out.println("ch = " + ch);
                        System.out.println("d " + d);
                        numStack.push(d);
                    }
                } else {
                    System.out.println("opstack Peek " + opStack.peek());
                    opStack.pop();
                    i++;
                }
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        int a = evaluate("(5-2)*(2+3)");
//        int a = evaluate("(1+2^3!-4)*(5!-(6-(7-(89-0!))))");
        System.out.println("----------------");
        System.out.println(a);
    }
}
