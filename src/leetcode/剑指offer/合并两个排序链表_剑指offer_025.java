package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * date： 2022/5/5
 * time： 16:43
 * author： cris
 * remark：
 **/
public class 合并两个排序链表_剑指offer_025 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while(l1 != null && l1 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre = l1 == null ? l2 : l1;
        return prehead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }
}
