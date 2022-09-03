package it.pers.raza.twopoints;

public class RemoveNthFromEnd {
    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int num = getLastNNode(head, n);
        if (num == n) {
            return head.next;
        }
        return head;
    }

    public static int getLastNNode(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int num = getLastNNode(head.next, n);
        if (num == n) {
            head.next = head.next.next;
        }
        return num + 1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        traverse(listNode, 2);
//        listNode = removeNthFromEnd(listNode, 2);
        System.out.println(listNode);
    }

    /**
     * 不清楚单链表单长度
     * 用双指针单话，可以得出需要删除的节点的位置，两个指针直接的距离为n
     *
     * @param head
     * @return
     */
    static ListNode traverse(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode last = head;
        int step = 0;
        while (last != null) {
            // 等到间隔为N的时候，last节点的偏移量刚刚好，则才开始启动dummp节点的指针操作
            if (step != n) {
                step++;
            } else {
                p.next = head;
                p = p.next;
                head = head.next;
            }
            last = last.next;
        }
        p.next = head.next;
        return dummy.next;
    }
}
