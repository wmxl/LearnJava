package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> li = new ArrayList<>();
            Queue<TreeNode> que = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode t = queue.poll();
                li.add(t.val);
                if(t.left != null) que.add(t.left);
                if(t.right != null) que.add(t.right);
            }
            queue = new LinkedList<>(que);
            list.add(li);
        }
        return list;
    }
}
