package leetcode.剑指offer;

/**
 * date： 2022/5/7
 * time： 10:50
 * author： cris
 * remark：
 **/
public class 删除链表节点_剑指offer_18 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return head.next;
        ListNode pre = head;                       //定义指针
        while (pre.next != null && pre.next.val != val) {
            pre = pre.next;
        }
        if(pre.next != null) pre.next = pre.next.next;      //判断最后一个
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(9);
        ListNode listNode = deleteNode(l1, 9);
        System.out.println(listNode);

    }
}
