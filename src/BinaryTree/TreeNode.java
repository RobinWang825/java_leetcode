package BinaryTree;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    // 构造方法
     public TreeNode(int val)
     {
         this.val = val;
     }
     public TreeNode(TreeNode left, int val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
     }


 }