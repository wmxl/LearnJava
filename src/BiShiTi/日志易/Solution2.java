package BiShiTi.日志易;

import java.util.*;

class TreeNode{
    TreeNode left,right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution2 {


    void inOrder(TreeNode root, List list){
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    TreeNode findKth1(TreeNode root, int k){
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        if(k > list.size()) return null;

        return list.get(k-1);
    }

    //
    TreeNode findKth2(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.isEmpty()){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                TreeNode node = stack.pop();

                if(--k == 0){
                    return node;
                }
            }
            root = root.right;
        }
        return null;
    }

    TreeNode find2th(TreeNode root){
        if(root == null) return null;
        TreeNode now = root, ans = root;

        while (now.left != null){
            ans = now;
            now = now.left;
        }

        if(now.right == null) return ans;

        ans = now.right;
        while (ans.left != null){
            ans = ans.left;
        }

        return ans;
    }



    public static void main(String[] args) {

    }
}
