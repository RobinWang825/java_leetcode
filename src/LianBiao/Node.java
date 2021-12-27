package LianBiao;

public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    // 构造方法 告诉节点的值 和 指针域
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}