package test;

import java.util.Scanner;

/**
 * test
 * Date： 2021/11/15 1:48 下午
 * User： cris
 * Description： 1
 **/
public class 石子合并2 {


    public static void main(String[] args) {
        int n,i,j,t,a,b;
        int[] arr = new int[100];
        int[][] sum = new int[100][100];
        int[][] dp = new int[100][100];
        int[][] dp2 = new int[100][100];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入堆数，按enter");
        n = scanner.nextInt();
        if(n == 0){
            System.out.println("无需操作");
        }else{
            for(int k = 1;k <= n;k++) {
                System.out.print("请输入第" + k + "堆的石头数目");
                arr[k] = scanner.nextInt();
            }
//        int min = calculate(n, sum, dp,arr);
            int[] res = calculate(n, sum, dp,arr,dp2);
            System.out.println("最小为：" + res[0]);
            System.out.println("最大为：" + res[1]);
        }
    }

    public static int[] calculate(int n,int[][] sum,int[][] dp,int[] arr,int[][] dp2){
        int max = 0;
        int a,b,c,d;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i==j) {
                    sum[i][j]=arr[i];
                }
                else
                    sum[i][j]=sum[i][j-1]+arr[j];
            }
        }                                //计算从i到j的石头总和
        for (int i=0; i<n; i++) {
            dp[i][i]=0;
            dp2[0][0]=0;
            if (i<n-1) {
                dp[i][i+1]=arr[i]+arr[i+1];
                dp2[i][i+1]=arr[i]+arr[i+1];
            }
        }                     //把同一堆石头和相邻两堆石头合并的值计算
        for (int t=2; t<=n; t++) {
            for (int i=0; i<n-t; i++) {
                a=dp[i][i+t-1]+sum[i][i+t];
                b=dp[i][i]+dp[i+1][i+t]+sum[i][i+t];
                c=dp2[i][i+t-1]+sum[i][i+t];
                d=dp2[i][i]+dp2[i+1][i+t]+sum[i][i+t];
                for (int j=1; j<t-1; j++) {
                    if (b>dp[i][i+j]+dp[i+j+1][i+t]+sum[i][i+t]) {
                        b=dp[i][i+j]+dp[i+j+1][i+t]+sum[i][i+t];
                    }
                    if(d < dp2[i][i+j]+dp2[i+j+1][i+t]+sum[i][i+t]){
                        d=dp2[i][i+j]+dp2[i+j+1][i+t]+sum[i][i+t];
                    }
                }
                if (a<=b) {
                    dp[i][i+t]=a;
                }
                else{
                    dp[i][i+t]=b;
                }
                if(c<=d){
                    dp2[i][i+t]=d;
                }else{
                    dp2[i][i+t]=c;
                }
            }
        }            //按照表格从副对角线往依次计算的方法，最后求出右上角的值
        int[] res = new int[]{dp[0][n-1],dp2[0][n-1]};
//        return dp[0][n-1];
        return res;
    }

}
