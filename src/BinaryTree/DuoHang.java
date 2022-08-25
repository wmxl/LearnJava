package BinaryTree;

import java.util.*;

public class DuoHang {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        else return list;
        ArrayList<Integer> li;
        while (!queue.isEmpty()) {
            li = new ArrayList<>();
            Queue<TreeNode> que = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                li.add(temp.val);
                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
            }
            queue = new LinkedList<>(que);
            list.add(li);
        }
        return list;
    }
}
