package LianBiao;

/**
 * 牛客：JZ22链表中倒数最后k个结点
 * lc: 06
 */
public class JZ22_k_node {
    public static void main(String[] args) {
        ListNode head2 = new ListNode(4);
        head2 = new ListNode(3, head2);
        head2 = new ListNode(2, head2);
        head2 = new ListNode(1, head2); //1->2->3->4
        ListNode kth = FindKthToTail(head2, 2); // 倒数第2个
        System.out.println(kth.val); // 3
    }

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        // 边界   链表长度如何计算  链表长度小于k，k-- > 0，走完链表长度之后，还大于0，就说明，k大于链表长度
        if(pHead==null) return null;
        ListNode p1 = pHead;
        // 方法1：先走K步   这个方法可以
        for(int i = 0;i < k; i++)
        {
            if(p1==null) return null; // 边界情况处理
            p1 = p1.next;
        }
        // 这个方法不行  跳不出去while循环了
//         while(p1!=null)
//         {
//             // 这样的话，k可能大于链表长度
//             for(int i = 0;i < k; i++){
//                 if(p1==null) return null;
//                 p1 = p1.next;
//             }
//         }

        // 方法2： p1先走k步
//         while (p1 != null && k-- > 0)
//             p1 = p1.next;
//         if (k > 0)
//             return null;

        // 双指针同时走
        ListNode p2 = pHead;
        while(p1!=null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
