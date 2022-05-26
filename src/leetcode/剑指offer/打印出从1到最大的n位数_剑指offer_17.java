package leetcode.剑指offer;

import java.util.Arrays;
import java.util.Map;

/**
 * date： 2022/5/10
 * time： 11:44
 * author： cris
 * remark：
 **/
public class 打印出从1到最大的n位数_剑指offer_17 {

    public static int[] printNumbers(int n) {
        int range = (int) Math.pow(10,n);
        int[] a = new int[range-1];
        for (int i = 1; i < range; i++) {
            a[i-1] = i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(3);
        System.out.println(Arrays.stream(ints).iterator());
    }

}
