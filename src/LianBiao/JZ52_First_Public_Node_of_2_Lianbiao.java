package LianBiao;

public class JZ52_First_Public_Node_of_2_Lianbiao {
    public static void main(String[] args) {
        // 怎么写例子
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ta = headA;
        ListNode tb = headB;
        while(ta!=tb)
        {
            ta = (ta==null)?headB:ta.next; // a+c+b 走完a+c也就是A链，走B的非共同部分b
            tb = (tb==null)?headA:tb.next; // b+c+a
        }
        return ta;
    }
}
