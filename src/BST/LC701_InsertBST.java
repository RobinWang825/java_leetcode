package BST;

public class LC701_InsertBST {
}
class LC701Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }
}