package BinaryTree;

public class LC106_inOrder_postOrder_buildTree {
    public static void main(String[] args) {
        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode treeNode = buildTree(in, post);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);

    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,
                    postorder,0,postorder.length-1);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart>inEnd || postStart>postEnd)
        {
            return null;
        }
        // 根节点的值
        int rootVal = postorder[postEnd];
        // 寻找 rootVal 在 inOrder中的位置 index，方便区分左右子树
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if(rootVal==inorder[i])
            {
                index = i;
                break;
            }
        }
        // 构建根节点
        TreeNode root = new TreeNode(rootVal);
        // 计算leftsize
        int leftsize = index - inStart;
        // 左右子树递归
        root.left = build(inorder,inStart,index-1,
                        postorder,postStart,postStart+leftsize-1);
        root.right = build(inorder,index+1,inEnd,
                        postorder,postStart+leftsize,postEnd-1);
        return root;
    }


}
