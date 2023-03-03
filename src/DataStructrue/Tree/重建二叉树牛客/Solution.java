package DataStructrue.Tree.重建二叉树牛客;

import java.util.*;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0) return null;

        ArrayList<Integer> leftPreList = new ArrayList<Integer>();
        ArrayList<Integer> leftInList = new ArrayList();
        ArrayList<Integer> rightPreList = new ArrayList();
        ArrayList<Integer> rightInList = new ArrayList();

        TreeNode root = new TreeNode(pre[0]);
        boolean half = false;
        int k = 1;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]) {
                half = true;
                continue;
            }
            if(!half){
                leftPreList.add(pre[k++]);
                leftInList.add(in[i]);
            }
            else {
                rightPreList.add(pre[k++]);
                rightInList.add(in[i]);
            }
        }

        int[] leftPre = leftPreList.stream().mapToInt(Integer::valueOf).toArray();
        int[] leftIn = leftInList.stream().mapToInt(Integer::valueOf).toArray();
        int[] rightPre = rightPreList.stream().mapToInt(Integer::valueOf).toArray();
        int[] rightIn = rightInList.stream().mapToInt(Integer::valueOf).toArray();

        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        System.out.println(new Solution().reConstructBinaryTree(pre, in));
    }
}