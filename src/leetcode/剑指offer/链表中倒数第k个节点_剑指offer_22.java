package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * date： 2022/5/7
 * time： 18:31
 * author： cris
 * remark：
 **/
public class 链表中倒数第k个节点_剑指offer_22 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 投机解法
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        List list = new ArrayList<Integer>();
        while(head.next != null){
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        ListNode res = new ListNode(-1);
        ListNode poi = res;
        for (int i = list.size()-k; i < list.size(); i++) {
            ListNode tmp = new ListNode((Integer) list.get(i));
            poi.next = tmp;
            poi = poi.next;
        }
        return res.next;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     * @deprecated 快指针先走k步，然后快慢指针同步走，党快指针走到头的时候，慢指针的位置就是第k个位置
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode quickNode = head; ListNode slowNode = head;
        while(quickNode.next != null && k > 0){
            quickNode = quickNode.next;
            k--;
        }

        while(quickNode.next != null){
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = new ListNode(5);
//        l1.next.next.next.next.next = new ListNode(6);
        ListNode kthFromEnd = getKthFromEnd2(l1, 1);
        System.out.println(kthFromEnd);
    }

    //快速排序
}
