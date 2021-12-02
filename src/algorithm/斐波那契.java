package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/29 7:12 下午
 * User： cris
 * Description： fibonacci
 **/
public class 斐波那契 {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int n = 45;
        int[] memo = new int[n+1];
        int fibonacci = fibonacci2(memo,n);
//        int fibonacci = fibonacci(n);
        long end = System.currentTimeMillis();
        System.out.println(fibonacci + "用时" + (end - begin) + "ms");


        //3
//        fibonacci3(8);
    }


    //1.普通算法
    public static int fibonacci(int n){
        if(n == 1 || n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //2.优化算法
    public static int fibonacci2(int[] memo,int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        //如果已经包含这个数，则不计算直接返回
        if(memo[n] != 0) return memo[n];
        memo[n] =  fibonacci2(memo,n-1) + fibonacci2(memo,n - 2);
        return memo[n];
    }

    //3.自底向上斐波那契
    public static void fibonacci3(int n){
        int pre = 0;
        int cur = 1;
        int sum = 0;
        for (int i = 2; i <= n ; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        System.out.println(sum);
    }
}
