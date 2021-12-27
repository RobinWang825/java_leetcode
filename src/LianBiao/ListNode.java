package LianBiao;

//public class ListNode {
//    int val;
//    LianBiao.ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    // 构造方法 告诉节点的值 和 指针域
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}