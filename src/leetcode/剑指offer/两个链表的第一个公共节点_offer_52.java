package leetcode.剑指offer;

/**
 * date： 2022/5/7
 * time： 10:50
 * author： cris
 * remark：
 **/
public class 两个链表的第一个公共节点_offer_52 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 双指针
     * @param headA
     * @param headB
     * @return
     * @Description 当两个链表长度不同，两个指针走完自己的后走另外一个链表，直到他们到达他们的第一个公共节点，此时他们走的路程相同。返回这个节点即可
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode PA = headA;
        ListNode PB = headB;
        while(PA != PB){
            PA = PA == null ? headB : PA.next;
            PB = PB == null ? headA : PB.next;
        }
        return PA;
    }
}
