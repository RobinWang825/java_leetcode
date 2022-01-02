package BinaryTree;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class LC116_Connect_Two_Node {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if(root==null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        //配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
        while(left!=null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }
}

