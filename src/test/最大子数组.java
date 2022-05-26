package test;

import java.util.Arrays;

/**
 * date： 2022/2/15
 * time： 11:39 AM
 * author： cris
 * remark：
 **/
public class 最大子数组 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3,1,3,-1,2,-4,2};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
