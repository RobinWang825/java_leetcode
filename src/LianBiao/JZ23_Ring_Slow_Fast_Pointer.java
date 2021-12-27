package LianBiao;

public class JZ23_Ring_Slow_Fast_Pointer {
    public static void main(String[] args) {
        // 有环
        // 1->2->3->4->2>...  可以画个图
        Node node = new Node(4);
        Node head = new Node(3,node);
        head = new Node(2,head);
        node.next = head; // 4->2
        head = new Node(1,head);
        Node loop = EntryNodeOfLoop(head);
        System.out.println(loop.value);
//        System.out.println(loop); //LianBiao.Node@4b67cf4d


        // 无环
        Node head2 = new Node(4);
        head2 = new Node(3, head2);
        head2 = new Node(2, head2);
        head2 = new Node(1, head2); //1->2->3->4

        Node nodeOfLoop = EntryNodeOfLoop(head2);
        System.out.println(nodeOfLoop); // null

    }
    public static Node EntryNodeOfLoop(Node pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        // 定义快慢指针
        Node slow = pHead, fast = pHead;
        while(fast != null && fast.next != null){
            // 快指针是慢指针的两倍速度
            fast = fast.next.next;
            slow = slow.next;
            // 记录快慢指针第一次相遇的结点
            if(slow == fast) break;
        }
        // 下面的方法，不加if 循环跳不出去
//         do {
//             if (fast==null || fast.next==null){
//                 return null;
//             }
//             fast = fast.next.next;
//             slow = slow.next;
//         } while (slow != fast);

        // 边界值 // 若是快指针指向null，则不存在环
        if(fast==null || fast.next==null ) return null;
        // 重新指向链表头部
        fast = pHead;
        // 与第一次相遇的结点相同速度出发，相遇结点为入口结点
        while(fast!=slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
