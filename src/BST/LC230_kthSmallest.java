package BST;

class lc230_kthSmallest {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int result = solution.kthSmallest();
//        System.out.println(result);
    }

}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root,k);
        return res;
    }
    int res = 0;
    int rank = 0; // 这个不能加static关键字，为什么
    private void traverse(TreeNode root, int k) {
        if(root==null){
            return;
        }
        traverse(root.left,k);
        rank++;
        if(k==rank){
            res = root.val;
            // return;
        }
        traverse(root.right,k);
    }
}
