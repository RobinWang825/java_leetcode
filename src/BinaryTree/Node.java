package BinaryTree;

public class Node {
     int val;
     Node left;
     Node right;
     Node next;
    // 构造方法
     public Node() {}
     public Node(int val)
     {
         this.val = val;
     }
     public Node(Node left, int val, Node right) {
        this.left = left;
        this.val = val;
        this.right = right;
        this.next = next;
     }
 }