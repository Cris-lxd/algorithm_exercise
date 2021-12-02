package algorithm;

/**
 * PACKAGE_NAME
 * Date： 2021/10/17 3:56 下午
 * User： cris
 * Description： 最大子序列
 * 1. 首数字为复数跳过
 * 2. 想加之后为复数舍弃
 **/
public class 求最大子序列 {

    public static int maxSequence(int[] a){
        int sum = 0;
        int max = 0;
        if(a[0] > 0){
            sum += a[0];
        }
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            max = sum > max ? sum : max;
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {-6, 2, 4 - 7, 5, 3, 2, -1, 6, -9, 10, -2};
        int sum = maxSequence(ints);
        System.out.println("最大的数字为：" + sum);
    }
}
