package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JZ32_1_leverOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode nodeleft = new TreeNode(2);
        TreeNode noderight = new TreeNode(3);
        TreeNode nodeleftleft = new TreeNode(4);
        TreeNode noderightleft = new TreeNode(2);
        TreeNode noderightleftleft = new TreeNode(4);
        TreeNode noderightright = new TreeNode(4);
        root.left = nodeleft;
        root.right = noderight;
        nodeleft.left = nodeleftleft;
        noderight.right = noderightright;
        noderight.left = noderightleft;
        noderightleft.left = noderightleftleft;
        JZ32Solution solution = new JZ32Solution();
        int[] result = solution.levelOrder(root);
        System.out.println(Arrays.toString(result));
//        ArrayList<Integer> list = solution.PrintFromTopToBottom(root);
//        System.out.println(list); //[1, 2, 3, 4, 2, 4, 4]

    }
}
class JZ32Solution {
    // 层序遍历
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        ArrayList<Integer> ret = new ArrayList<>();
        // int[] ret = new int[];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode x = queue.poll();
            ret.add(x.val);
//            System.out.println("ret: "+ret);
            if(x.left!=null) queue.offer(x.left);
            if(x.right!=null) queue.offer(x.right);
        }
        int[] ans = new int[ret.size()];

        for(int i = 0; i<ret.size();i++){
            // System.out.println(ret.get(i));
            ans[i] = ret.get(i);
        }
        return ans;
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(root==null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();

        // 根节点入队列
        queue.offer(root);
        // 判断队列是否为空
        while(!queue.isEmpty()){
            TreeNode x = queue.poll(); // 出队列
            ret.add(x.val);
            // 判断是否有左右孩子
            if(x.left!=null) queue.offer(x.left);
            if(x.right!=null) queue.offer(x.right);
        }
        return ret;
    }
}