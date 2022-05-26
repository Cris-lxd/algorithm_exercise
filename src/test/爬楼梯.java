package test;

import java.util.Arrays;

/**
 * date： 2022/3/27
 * time： 4:58 PM
 * author： cris
 * remark：
 **/
public class 爬楼梯 {

    //递归
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        return climb(n,dp);
    }
    public static int climb(int n, int[] dp){
        if(n == 1) return 1;
        if(n == 0) return 1;
        int a=0,b=0;
        if(dp[n-1] == 0){
            a = climb(n - 1,dp);
            dp[n-1] = a;
        }
        if(dp[n-2] == 0){
            b = climb(n-2, dp);
            dp[n-2] = b;
        }
        return dp[n-1] + dp[n-2];
    }


    //dp
    public static int climbStairs1(int n){
        int a=0;
        int temp1 = 1;          //n-2阶梯
        int temp2 = 1;          //n-1阶梯
        for (int i = 2; i < n; i++) {
            a = temp2;
            temp2 = a+temp1;
            temp1 =a;
        }
        return temp1 + temp2;
    }


    public static void main(String[] args) {

        //递归
        int i = climbStairs(10);
        System.out.println(i);

        //dp
        int i1 = climbStairs1(10);
        System.out.println(i1);
    }
}
