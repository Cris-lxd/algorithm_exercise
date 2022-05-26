package test;

import java.util.Arrays;

/**
 * date： 2022/3/24
 * time： 3:13 PM
 * author： cris
 * remark：
 **/

public class 最大字数组 {

    public static int getMaxArray(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        int[] a = new int[]{-3, 1, 3 - 1, 2, -4, 2};
        int maxArray = getMaxArray(a);
        System.out.println(maxArray);
    }
}
