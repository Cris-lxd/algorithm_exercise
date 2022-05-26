package leetcode.剑指offer;

import java.util.Stack;

/**
 * date： 2022/5/25
 * time： 17:16
 * author： cris
 * description：
 **/
public class demensions_interview {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //判断是否为回文数
    public boolean checkNum(int num) {
        String nums = String.valueOf(num);
        if(nums.length()%2 == 0) return false;
        Stack stack = new Stack();
        int n = nums.length()/2;
        for (int i = 0; i < n; i++) {       //栈存放nums前一半的数据
            stack.push(nums.charAt(i));
        }
        for (int i = n+1; i < nums.length(); i++) {
            if(!String.valueOf(nums.charAt(i)).equals(stack.pop())){        //判断栈顶元素是否等于数组一半以后数据的数字，不等于则不为回文整数，返回false
                return false;
            }
        }
        return true;
    }

    //合并升序列表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p = l1 == null ? l2 : l1;
        return res.next;
    }

    //删除数组元素
    public int expectedNums(int[] nums){
        int res = 0;       //记录重复个数
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i] == nums[i-1]){
                for (int j = i+1; j < n; j++) {
                    nums[j-1] = nums[j];
                }
                n -= 1;    //变化需要遍历的nums长度
                res++;      //重复个数自增
            }
        }
        return nums.length-res;
    }


}
