package test;

import java.util.Scanner;

/**
 * test
 * Date： 2021/11/15 1:27 下午
 * User： cris
 * Description： 石子合并
 **/
public class 石子合并 {


    public static int calculate(int N,int[][] sum,int[] num,int[][] dp,int inf){
        for(int i = 1;i <= N;i++)
            for(int j = i;j <= N;j++){
                if(i == j)
                    sum[i][j] = num[i];      //计算从i到j的石子总重量
                else
                    sum[i][j] = sum[i][j-1] + num[j];
            }
        for(int j = 2;j <= N;j++)
            for(int i = j -1 ; i > 0;i--){
                dp[i][j] = inf;            //通过两次循环来找到所有的i和j的相对位置
                for(int k = i;k < j ;k++)
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k+1][j] + sum[i][j]);
                //每次要寻找dp[i][j]的最优解时，要保证dp[i][k]和dp[k+1][j]已经在前面计算出
                //通过 j从最小值开始向后递增，在每次j固定的情况下i每，i从j-1开始向前就可以确保 dp[i][k]和dp[k+1][j]已经计算过
            }
        return dp[1][N]; //返回从1
    }

    public static void main(String[] args) {
        int inf = Integer.MIN_VALUE;
        int maxn = 1001;
        int N;
        int[][] dp =new int[maxn][maxn];
        int[][] sum =new int[maxn][maxn];
        int[] num = new int[maxn];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入堆数，按enter");
        N = scanner.nextInt();
        for(int i = 1;i <= N;i++) {
            System.out.println("请输入第" + i + "堆的石头数目");
            num[i] = scanner.nextInt();
        }
        int minCost = calculate(N, sum, num, dp, inf);
        System.out.println(minCost);

    }
}