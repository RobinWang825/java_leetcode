package LianBiao;

/**
 * JZ25 合并2个排序的链表
 */
public class JZ25_Merge_2_Sorted_LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head = new ListNode(2, head);
        head = new ListNode(1, head); //1->2->3

        ListNode head2 = new ListNode(4);
        head2 = new ListNode(3, head2);
        head2 = new ListNode(2, head2); //2->3->4

        ListNode node = Merge2(head,head2);
        while(node!=null){
            System.out.print(node.val+" "); // 1 2 2 3 3 4
            node = node.next;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        // 方法1：递归
        // 如果有一个链表为空 返回另一个链表
        if(list1==null) return list2;
        if(list2==null) return list1;
        // 比较节点大小，取较小值作头结点
        if(list1.val<=list2.val)
        {
            list1.next = Merge(list1.next,list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        // 方法2：迭代
        if(list1==null) return list2;
        if(list2 == null) return list1;
        // 初始化： 伪头节点 result, 节点cur指向 result
        // cur只指向一个节点，而 result 是从头开始的整个链表。
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while(list1!=null && list2!=null)
        { //当两个链表都非空时进入循环
            if(list1.val <= list2.val)
            { //令新链表的下一个节点cur.next为val更小的节点
                cur.next = list1;
                list1 = list1.next; //相应的链表节点后移一位
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            // 每次循环记得cur也要后移一位
            cur = cur.next;
        }
        // 如果循环结束后还有链表非空，cur指向非空链表，返回result.next
        // 拼接没有比对的链表
        cur.next = list1!=null ? list1 : list2;
//         cur.next = list1 if(list1==null) else list2;
        return result.next;
    }
}
