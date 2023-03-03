package Leecode周赛.week234;

import java.util.*;

public class Solution {
    /*
    给你一个字符串 word ，该字符串由数字和小写英文字母组成。

请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。

返回对 word 完成替换后形成的 不同 整数的数目。

如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
     */
    public int numDifferentIntegers(String word) {
        Map map = new HashMap();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > '9' || word.charAt(i) < '0') {
                sb.append(' ');
            }else {
                sb.append(word.charAt(i));
            }
        }
        String[] strings = sb.toString().trim().split("\\s+");
        System.out.println(strings.length);
        System.out.println(strings[0].length());
        if(strings.length == 1 && strings[0].length()==0)return 0;
        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
            String s = strings[i];
            int j;
            for (j = 0; j < s.length(); j++) {
                if(s.charAt(j) != '0') break;
            }
            System.out.println(s.substring(j));

            map.put(s.substring(j), 1);
        }
        return map.size();
    }

    /*
      给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。

一步操作中，你将创建一个新数组 arr ，对于每个 i ：

如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
然后将 arr​​ 赋值​​给 perm 。

要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。



示例 1：

输入：n = 2
输出：1
解释：最初，perm = [0,1]
第 1 步操作后，perm = [0,1]
所以，仅需执行 1 步操作
示例 2：

输入：n = 4
输出：2
解释：最初，perm = [0,1,2,3]
第 1 步操作后，perm = [0,2,1,3]
第 2 步操作后，perm = [0,1,2,3]
所以，仅需执行 2 步操作
示例 3：

输入：n = 6
输出：4
     */
    public static boolean equals(int[] a,int[] b)
    {
        for (int i=0;i !=a.length;i++)
            if (a[i] != b[i]) return false;
        return true;
    }
    int[] opt(int[] a){
        for (int i = 0; i < a.length; i++) {
            if(a[i] % 2 == 0) a[i] = a[i] / 2;
            else a[i] = a.length/2 + (a[i]-1)/2;
        }
        return a;
    }
    public int reinitializePermutation(int n) {
        int[] a = new int[n];
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
            a1[i] = i;
        }
        int cnt = 0;
        while (cnt < 999999){
            a = opt(a);
//            System.out.println(Arrays.toString(a));
            cnt++;
//            Arrays.toString(a);
            if(equals(a,a1) ) return cnt;
        }
        System.out.println(cnt);
        return 0;
    }

    /**
     * 5714. 替换字符串中的括号内容 显示英文描述

     * 题目难度Medium
     * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
     *
     * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
     * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
     *
     * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
     *
     * 将 keyi 和括号用对应的值 valuei 替换。
     * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
     * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
     *
     * 请你返回替换 所有 括号对后的结果字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
     * 输出："bobistwoyearsold"
     * 解释：
     * 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
     * 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
     * 示例 2：
     *
     * 输入：s = "hi(name)", knowledge = [["a","b"]]
     * 输出："hi?"
     * 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
     * 示例 3：
     *
     * 输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
     * 输出："yesyesyesaaa"
     * 解释：相同的键在 s 中可能会出现多次。
     * 键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
     * 注意，不在括号里的 "a" 不需要被替换。
     * 示例 4：
     *
     * 输入：s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
     * 输出："ba"
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap map = new HashMap();
        for (int i = 0; i < knowledge.size(); i++) {
            System.out.println(knowledge.get(i));
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        StringBuffer sb = new StringBuffer();
        int j= 0;
        for (int i = 0; i < s.length(); i++) {

            StringBuffer sb1 = new StringBuffer();
            if(s.charAt(i) == '('){

                for (j = i+1; s.charAt(j) != ')'; j++) {
                    sb1.append(s.charAt(j));
                }
                System.out.println(sb1);
                if(map.containsKey(sb1.toString()))
                    sb.append(map.get(sb1.toString()));
                else
                    sb.append("?");
                i = j;continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        List a = new ArrayList<String>();
        a.add("name");a.add("bob");
        List b = new ArrayList<String>();
        b.add("age");b.add("tw");
        List c = new ArrayList();
        c.add(a);c.add(b);


            System.out.println(new Solution().evaluate("(name)is(age)yearsold", c));


    }
}
