package BST;

public class LC98_Validate_BST {

}
class LC98Solution{
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 边界
        if(root == null) return true;

        // 左子树
        if(!isValidBST(root.left))
        {
            return false;
        }
        // 当前节点
        if(root.val<=pre) return false;
        // pre要变化
        pre = root.val;
        // 右子树
        return isValidBST(root.right);
    }

}
