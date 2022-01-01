package BinaryTree;

import java.util.*;

public class JZ7_reBuild_Tree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);

//        TreeNode node = reConstructBinaryTree1(pre, in);
//        System.out.println(node.val);
//        System.out.println(node.left.val);
//        System.out.println(node.right.val);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 牛客解法1：递归；
        return dfs(0, 0, in.length - 1, pre, in);
    }

    public static TreeNode dfs(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
        // 边界情况
        if (preStart > preOrder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);// 根节点
        int index = 0;
        // i的边界值范围错了
        // 应该是inStart到inEnd，而不是，inStart到inOrder.length
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root.val) {
                index = i;
                break;
            }
        }
        // 都写在for循环外面
        root.left = dfs(preStart + 1, inStart, index - 1, preOrder, inOrder);
        root.right = dfs(preStart + index - inStart + 1, index + 1, inEnd, preOrder, inOrder);
        return root;
    }

    // 牛客题解
    public static TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        return dfs1(0, 0, in.length - 1, pre, in);
    }

   public static TreeNode dfs1(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //创建结点
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        //找到当前节点root在中序遍历中的位置，然后再把数组分两半
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = dfs1(preStart + 1, inStart, index - 1, preorder, inorder);
        root.right = dfs1(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }

}