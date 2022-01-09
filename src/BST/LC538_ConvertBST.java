package BST;

/**
 * 力扣第 538 题和 1038 题都是 【BST 转化累加树】
 */
public class LC538_ConvertBST {
}
class ConvertBSTSolution {
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    int sum = 0;
    private void traverse(TreeNode root) {
        if(root==null) return;
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

}
