package leetcode.剑指offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * date： 2022/5/12
 * time： 10:20
 * author： cris
 * description：
 **/
public class 找出滑动窗口的最大值_剑指offer_59 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int n = nums.length;
        int[] maxVal = new int[n-k+1];
        for (int i = 0; i <= nums.length-k; i++) {
            int j = 0;
            int[] window = new int[k];
            while(j < k){           //为了存放该窗口内的值
                window[j] = nums[i+j];
                j++;
            }
            int max = Integer.MIN_VALUE;
            for (int l = 0; l < window.length; l++) {
                if(window[l] > max) max = window[l];
            }
            maxVal[i] = max;
        }
        return maxVal;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow1(nums, k);
        System.out.println(ints);
    }

}
