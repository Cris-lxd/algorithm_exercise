package algorithm;

/**
 * 最大连续子序列
 */
public class MaxQueue {
    static int maxSubSum3(int a[],int n)
    {  int j,maxSum=0,thisSum=0;
        for (j=0;j<n;j++)
        {
            thisSum+=a[j];
            if (thisSum<0){
                thisSum = 0;
                continue;
            }
            if (maxSum<thisSum) {
                //比较求最大连续子序列和
                maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int maxSum = maxSubSum3(new int[]{1,-2,3,-1,2,3,2}, 3);
        System.out.println(maxSum);
    }
}
