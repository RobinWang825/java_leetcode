package LianBiao;

/**  JZ18.2  删除链表中重复结点   的两种解法
 * https://blog.nowcoder.net/n/4cd624d0bc90481bacf046e3b655a2a0?f=comment
 */

public class JZ18_2_Delete_repeat_node {
    public static void main(String[] args) {
        //构建链表 1->2->3->4
        Node head = new Node(4);
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);
        head = new Node(1, head);
        head = new Node(1, head);
        head = new Node(1, head);
        Node duplication = deleteDuplication(head);
        while(duplication!=null){
            System.out.println(duplication.value);
            duplication = duplication.next;
        }
    }
    // 解法1：迭代解法  --  尾插法
    public static Node deleteDuplication(Node pHead) {
        // 1. 建一个「虚拟头节点」dummy 以减少边界判断，往后的答案链表会接在 dummy 后面；
        Node dummy = new Node(-1);
        // 2. 使用 tail 代表当前有效链表的结尾；
        Node tail = dummy; // 尾插法，tail始终指向表尾
        // 3. 通过原输入的 pHead 指针进行链表扫描。
        while (pHead != null) {
            // 进入循环时，确保了 pHead 不会与上一节点相同
            if (pHead.next == null || pHead.next.value != pHead.value) {
                tail.next = pHead; // 要插入的结点 pHead
                tail = pHead; // 始终指向表尾
            }
            // 如果 pHead 与下一节点相同，跳过相同节点（到达「连续相同一段」的最后一位）
            while (pHead.next != null && pHead.value == pHead.next.value) pHead = pHead.next;
            pHead = pHead.next;
        }
        tail.next = null; // 完成链表
        return dummy.next;
    }

    // 解法2：递归解法
    public static Node deleteDuplication2(Node pHead) {
        // 1. 递归出口：当「输入节点为空」或者「不存在下一节点」，直接返回
        if (pHead == null || pHead.next == null) return pHead;
        // 2. 递归环节的最小操作
        if (pHead.value != pHead.next.value) {
            // 若「当前节点」与「下一节点」值不同，则当前节点可以被保留
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        } else {
            // 若「当前节点」与「下一节点」相同，需要跳过「值相同的连续一段」
            // 使用临时变量 tmp 跳过「与 pHead.val 值相同的连续一段」，将 tmp 传入递归函数所得的结果作为本次返回。
            Node tmp = pHead;
            while (tmp != null && tmp.value == pHead.value) tmp = tmp.next;
            return deleteDuplication(tmp);
        }
    }



}
