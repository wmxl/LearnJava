package BiShiTi.WeiPingHui;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int ma = 0;
    public int GetDiameter(TreeNode root){
        dep(root);
        return ma;
    }
    public int dep(TreeNode root){
        if(root == null) return 0;
        int left = dep(root.left);
        int right = dep(root.right);
        ma = Math.max(ma, left + right);
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        t.left = t1;
        t.right = t2;
        System.out.println(new Main().GetDiameter(t));

    }
}
