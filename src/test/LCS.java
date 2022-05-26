package test;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * date： 2022/3/24
 * time： 4:05 PM
 * author： cris
 * remark：
 **/
public class LCS {
    public static int getLCS(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(s1.charAt(i) == s1.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int lcs = getLCS("abcde", "aceb");
        System.out.println(lcs);
    }
}
