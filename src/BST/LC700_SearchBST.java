package BST;

public class LC700_SearchBST {
}
class lc700Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // 空间复杂度O(1), 时间复杂度O(n)
        while (root!=null){
            if(root.val == val){
                return root;
            }
            //
            root = val> root.val?root.right:root.left;
        }
        return null;
    }
}