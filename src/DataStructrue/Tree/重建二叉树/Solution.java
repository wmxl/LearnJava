package DataStructrue.Tree.重建二叉树;
import java.util.*;
import java.lang.Math;

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char x) {
        val = x;
    }
}

public class Solution {
    static public List<Character> preorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (char i : preorderTraversal(root.left)) {
            list.add(i);
        }
        for (char i : preorderTraversal(root.right)) {
            list.add(i);
        }
        return list;
    }

    static public TreeNode reConstructBinaryTree(char[] in, char[] post) {
        if(post.length == 0) return null;

        TreeNode root = new TreeNode(post[post.length-1]);

        int leftS = find(in, post[post.length-1]);

        char[] leftIn = Arrays.copyOfRange(in, 0, leftS);
        char[] leftPost = Arrays.copyOfRange(post, 0, leftS);
        root.left = reConstructBinaryTree(leftIn, leftPost);

        char[] rightIn = Arrays.copyOfRange(in, leftS + 1, in.length);
        char[] rightPost = Arrays.copyOfRange(post, leftS, post.length-1);
        root.right = reConstructBinaryTree(rightIn, rightPost);

        return  root;
    }

    static int find(char[] a, int v){
        for (int i = 0; i < a.length; i++) {
            if(a[i] == v) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2  = sc.next();

        char[] pre = s1.toCharArray();
        char[] in = s2.toCharArray();

        TreeNode tree = reConstructBinaryTree(pre, in);

        List<Character> list = preorderTraversal(tree);

        for(char c : list){
            System.out.print(c);
        }
        System.out.println();
    }
}

/*
dgbaechf
gbdehfca
 */