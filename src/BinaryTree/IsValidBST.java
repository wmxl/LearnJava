package BinaryTree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class IsValidBST {
    public boolean smaller(TreeNode root, int val) {
        if(root == null) return true;
        return root.val < val && smaller(root.right, val) && smaller(root.left, val)
                && smaller(root.left, root.val) && bigger(root.right, root.val);
    }
    public boolean bigger(TreeNode root, int val) {
        if(root == null) return true;
        return root.val > val && bigger(root.right, val) && bigger(root.left, val)
                && smaller(root.left, root.val) && bigger(root.right, root.val);
    }

    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;
        return smaller(root.left, root.val) && bigger(root.right, root.val);
    }


    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
