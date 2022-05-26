package test;

import java.util.Arrays;

public class 递增子序列 {
    public static int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];              //这里的dp[i]代表第i个位置最长的序列是多少，即i为i时的最优解
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);            //状态转移方程，当前最长的序列   or  前一个长度最长序列+1
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,23,5,3,7,101,18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
