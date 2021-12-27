package LianBiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 */

public class JZ06_Reverse_List {
    public static void main(String[] args) {
        //构建链表 1->2->3->4
        Node head = new Node(4);
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);
        int[] ints = reversePrint1(head);

        System.out.println(Arrays.toString(ints)); // 4321

        ListNode head2 = new ListNode(4);
        head2 = new ListNode(3, head2);
        head2 = new ListNode(2, head2);
        head2 = new ListNode(1, head2);
        System.out.println(printListFromTailToHead(head2));

// 不能运行
//        ListNode listNode = new ListNode(4);
//        listNode = listNode.next;
//        listNode = new ListNode(3);
//        listNode = listNode.next;
//        listNode = new ListNode(2);
//        listNode = listNode.next;
//        listNode = new ListNode(1);
//        listNode = listNode.next;
////        System.out.println(listNode);
//        int[] ints1 = reversePrint(listNode);
//        System.out.println(Arrays.toString(ints1));

//        System.out.println(reversePrint(listNode));

    }
    // Node
    public static int[] reversePrint1(Node head) {
        // 不使用栈
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
//            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size - i -1);
        }
        return array;

    }
    // ListNode
    public static int[] reversePrint(ListNode head) {
        // 不使用栈
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size - i -1);
        }
        return array;

    }
    // 头插法  牛客
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 方法1：头插法
        ListNode head = new ListNode(-1); // 头结点
        while(listNode!=null){
            ListNode meno = listNode.next; // 记录listNode的下一个结点的值 不然后面没法使用
            // System.out.println(listNode.val); // 1 2 3 4
            listNode.next = head.next;
            head.next = listNode;
            listNode = meno;
//             listNode = listNode.next; // 为啥没有meno不行
        }
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while(head!=null){
            ret.add(head.val);
            head = head.next;
        }
        return ret;
        // 方法2
//         ArrayList<Integer> list = new ArrayList<>();
//         while (listNode != null) {
//             list.add(listNode.val);
//             listNode = listNode.next;
//         }
//         int size = list.size();
//         ArrayList<Integer> ret = new ArrayList<>();
// //         int[] array = new int[size];
//         for (int i = 0; i < size; i++) {
//             ret.add(list.get(size - i -1));
// //             array[i] = list.get(size - i -1);
//         }
//         return ret;

    }

}
