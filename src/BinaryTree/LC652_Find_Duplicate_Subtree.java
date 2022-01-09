package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC652_Find_Duplicate_Subtree {

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

        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(root);
        System.out.println(duplicateSubtrees.size());//2
        // 第一个重复的子树  4
        System.out.println(duplicateSubtrees.get(0).val); // 4

        // 第二个重复的子树 2
        //              /
        //             4
        System.out.println(duplicateSubtrees.get(1).val); // 2
        System.out.println(duplicateSubtrees.get(1).left.val); // 4


    }
    // 记录所有子树和出现的次数
    static HashMap<String, Integer> memo = new HashMap<>();
    // 记录重复的子树根节点
    static LinkedList<TreeNode> res = new LinkedList<>();
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    // 辅助函数
    private static String traverse(TreeNode root) {
        // 把二叉树 序列化
        if(root == null){
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left+","+right+","+root.val; // subTree: #,#,4;  #,#,4,#,2等
        System.out.println(subTree);

        // 把构建的多个子树加入到memo中，重复的加入到res中
        // 根据subTree出现的频率freq判断
        int freq = memo.getOrDefault(subTree,0);
        if(freq==1){
            res.add(root);// 避免重复添加多次
        }
        // 给子树对应的出现次数+1
        memo.put(subTree,freq+1);
        // 返回 序列化后 的 子树 （String类型）
        return subTree;
    }

}
