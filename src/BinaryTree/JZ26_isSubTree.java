package BinaryTree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class JZ26_isSubTree {

}

class JZ26Solution {
    // 递归判断子树里有无所求子结构
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)// 边界条件 空树返回false
            return false;
        if (isSubtreeWithRoot(root1, root2))// 递归判断是否是子结构
            return true;
        //递归判断左右节点有无子结构
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //递归判断是否是子结构
    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)//判断头节点
            return false;
        //递归判断左侧节点和右侧节点，左右节点都相同才是子结构
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}