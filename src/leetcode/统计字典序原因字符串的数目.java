package leetcode;

/**
 * leetcode
 * Date： 2021/11/9 5:14 下午
 * User： cris
 * Description： 统计字符串长度
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 **/
public class 统计字典序原因字符串的数目 {
    public static int countVowelStrings(int n) {
        if(n == 0) return 0;
        if(n == 1) return 5;
        int[] dp = {1,1,1,1,1};
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 5; j++){
                for(int k = j+1; k < 5; k++){
                    dp[j] += k;
                }
            }
        }
        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }

    public static void main(String[] args) {
        int sum = countVowelStrings(3);
        System.out.println(sum);
    }
}
