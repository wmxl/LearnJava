package DataStructrue.Tree.BinaryTree;



import java.util.*;

// Definition for a binary tree node.

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 先序遍历-递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        for (Integer i : preorderTraversal(root.left)) {
            list.add(i);
        }
        for (Integer i : preorderTraversal(root.right)) {
            list.add(i);
        }
        return list;
    }

    //先序遍历-非递归 我自己写的方法，需要标记
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        TreeNode temp = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (true) {
            if (temp.left != null && temp.left.val != 9999) {
                nodeStack.add(temp);
                temp = temp.left;
                list.add(temp.val);
                System.out.println(temp.val);
                temp.val = 9999;
            } else if (temp.right != null && temp.right.val != 9999) {
                temp = temp.right;
                list.add(temp.val);
                System.out.println(temp.val);
                temp.val = 9999;
            } else {
                temp.val = 9999;
                if (nodeStack.empty() == true) break;
                temp = nodeStack.pop();
            }
        }
        return list;
    }

    //先序遍历-非递归 最佳写法
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !nodeStack.empty()) {
            while (temp != null) {
                nodeStack.add(temp);
                list.add(temp.val);
                temp = temp.left;
            }
            temp = nodeStack.pop();
            temp = temp.right;
        }
        return list;
    }

    //中序遍历-递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        for (Integer i : inorderTraversal(root.left)) {
            list.add(i);
        }
        list.add(root.val);
        for (Integer i : inorderTraversal(root.right)) {
            list.add(i);
        }
        return list;
    }

    //中序遍历-非递归
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !nodeStack.empty()) {
            while (temp != null) {
                nodeStack.add(temp);
                temp = temp.left;
            }
            temp = nodeStack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }

    //后序遍历-递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        for (Integer i : postorderTraversal(root.left)) {
            list.add(i);
        }
        for (Integer i : postorderTraversal(root.right)) {
            list.add(i);
        }
        list.add(root.val);
        return list;
    }

    //后序遍历-非递归 自己写的，需要标记
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = root;
        nodeStack.add(temp);
        while (temp != null || !nodeStack.empty()) {
            if (temp == null) {
                temp = nodeStack.peek();
                if (temp.left == null) {
                    if (temp.right == null) {
                        list.add(temp.val);
//                        System.out.println(list);
//                        System.out.println(nodeStack);
                        temp.val = 999;
                        nodeStack.pop();
                    } else if (temp.right.val == 999) {
                        list.add(temp.val);
                        System.out.println(list);
                        System.out.println(nodeStack);
                        temp.val = 999;
                        nodeStack.pop();
                    }
                } else if (temp.left.val == 999) {
                    if (temp.right == null) {
                        list.add(temp.val);
                        System.out.println(list);
                        System.out.println(nodeStack);
                        temp.val = 999;
                        nodeStack.pop();
                    } else if (temp.right.val == 999) {
                        list.add(temp.val);
                        System.out.println(list);
                        System.out.println(nodeStack);
                        temp.val = 999;
                        nodeStack.pop();
                    }
                }
            }
            if (temp.right != null) {
                if (temp.right.val == 999) {
                    if (temp.left == null) {
                        temp = null;
                        continue;
                    } else if (temp.left.val == 999) {
                        temp = null;
                        continue;
                    }
                } else {
                    nodeStack.add(temp.right);
                }
            } else {
                if (temp.left == null) {
                    temp = null;
                    continue;
                } else if (temp.left.val == 999) {
                    temp = null;
                    continue;
                }
            }
            if (temp.left != null) {
                if (temp.left.val == 999) {
                    temp = null;
                    continue;
                } else {
                    nodeStack.add(temp.left);
                }
            }
            if (temp.left != null && temp.left.val != 999) {
                temp = temp.left;
                continue;
            }
            if (temp.right != null && temp.right.val != 999) {
                temp = temp.right;
                continue;
            }
        }
        return list;
    }

    //后序遍历-非递归 双栈实现
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> dataStack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !nodeStack.empty()) {
            while (temp != null) {
                nodeStack.push(temp);
                dataStack.push(temp.val);
                temp = temp.right;
            }
            temp = nodeStack.pop();
            temp = temp.left;
        }
//        for (Integer i : dataStack){
//            list.add(i);
//        }//这个是从栈底到栈顶的顺序，并不是栈的出栈的正规顺序
        while (!dataStack.empty()) {
            list.add(dataStack.pop());
        }
        return list;
    }

    //后序遍历-非递归 最后一种取巧的方法，先按先序遍历（但是要先右后左） 然后再逆序一下
    // 其实上面也是这样的，只不过用stack来实现逆序
    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !nodeStack.empty()) {
            while (temp != null) {
                nodeStack.add(temp);
                list.add(temp.val);
                temp = temp.right;
            }
            if (!nodeStack.empty()) {
                temp = nodeStack.pop();
                temp = temp.left;
            }
        }
        Collections.reverse(list);
        return list;
    }

    //二叉树的层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
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
            System.out.println(li);
            list.add(li);
        }
        return list;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //判断是否是对称树
    public boolean isSym(TreeNode leftTree, TreeNode rightTree) {
        //左右至少右一个是null的情况
        if (leftTree == null) {
            if (rightTree == null) return true;
            else return false;
        } else {
            if (rightTree == null) return false;
        }
        //左右都不为null, 先看这个节点本树的值是不是一样
        if (leftTree.val != rightTree.val) return false;
        //本身值一样，再看他们的左子树是不是和右子树对称
        if (isSym(leftTree.left, rightTree.right) && isSym(leftTree.right, rightTree.left)) return true;
        else return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //判断两棵树是不是一模一样
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1 != null && root2 == null) return false;
        if (root1.val != root2.val) return false;
        else return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    //判断是不是一棵树的子树
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (isSameTree(root1, root2)) return true;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //判断是不是从根开始包含另一个棵树
    public boolean containSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        boolean[] flags = new boolean[2];
        for (int i = 0; i < 2; i++) {
            TreeNode tree1, tree2;
            if (i == 0) {
                tree1 = root1.left;
                tree2 = root2.left;
            } else {
                tree1 = root1.right;
                tree2 = root2.right;
            }
            if (tree2 == null) flags[i] = true;
            else {
                if (tree1 == null) flags[i] = false;
                else flags[i] = containSubTree(tree1, tree2);
            }
        }
        return flags[0] && flags[1];
    }

    //判断是不是一棵树的子结构
    public boolean HasSubStructure(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (containSubTree(root1, root2)) return true;
        return HasSubStructure(root1.left, root2) || HasSubStructure(root1.right, root2);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = nums[0], k = 0;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                k = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < k) left.add(nums[i]);
            if(i > k) right.add(nums[i]);
        }
        TreeNode ans = new TreeNode(max);

        if(left.size() == 0)
            ans.left = null;
        else{
            int[] leftArr = new int[left.size()];
            for (int i = 0; i < left.size(); i++) {
                leftArr[i] = left.get(i);
            }
            ans.left = constructMaximumBinaryTree(leftArr);
        }
        if(right.size() == 0)
            ans.right = null;
        else{
            int[] rightArr = new int[right.size()];
            for (int i = 0; i < right.size(); i++) {
                rightArr[i] = right.get(i);
            }
            ans.right = constructMaximumBinaryTree(rightArr);
        }

        return ans;
    }

    //根据牛客网上的二叉树的字符串建立一棵二叉树，并返回此二叉树
    public TreeNode Serialize(String str) {
        String[] strs = str.split(",");
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int ceng = 1;
        for (int i = 0; i < strs.length; ) {
            ArrayList<String> li = new ArrayList<>();
            for (int j = 0; j < ceng && i < strs.length; j++) {
                String s = strs[i];
                li.add(s);
                i++;
            }
            ceng = ceng * 2;
            list.add(li);
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0).get(0)));
        ArrayList<TreeNode> lastTreeList;
        ArrayList<TreeNode> treeList = new ArrayList<>();
        treeList.add(root);
        for (int i = 1; i < list.size(); i++) {
            lastTreeList = new ArrayList<>(treeList);
            treeList.clear();
            for (int j = 0, k = 0; j < list.get(i).size(); j++) {
                String node = list.get(i).get(j);
                TreeNode lastTn = lastTreeList.get(k);
//                System.out.println(t);
                if (lastTn == null) {
                    k++;
                    continue;
                }
                if (j % 2 == 0) {
                    if (node.equals("#")) {
                        lastTn.left = null;
                        treeList.add(null);
                    } else {
                        lastTn.left = new TreeNode(Integer.parseInt(node));
                        treeList.add(lastTn.left);
                    }
                } else {
                    if (node.equals("#")) {
                        lastTn.right = null;
                        treeList.add(null);
                    } else {
                        lastTn.right = new TreeNode(Integer.parseInt(node));
                        treeList.add(lastTn.right);
                    }
                    k++;
                }
            }
        }
        return root;
    }

    // 得到一个树的直径
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
        Solution sol = new Solution();
        String s = "8,8,7,9,2,#,#,#,#,4,7";
        TreeNode tree = sol.Serialize(s);
        String s1 = "8,9,2,#,#,4,7";
        TreeNode tree1 = sol.Serialize(s1);

        System.out.println(sol.containSubTree(tree, tree1));
        System.out.println(sol.HasSubStructure(tree, tree1));


    }
}
