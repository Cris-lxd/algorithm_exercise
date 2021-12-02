package leetcode;

/**
 * leetcode
 * Date： 2021/11/22 5:49 下午
 * User： cris
 * Description： 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 **/
public class 消失的数字1701 {

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int i : nums) sum +=i;
        return ((1+nums.length)*nums.length/2) - sum;
    }

    public static void main(String[] args) {
        int[] a = {9,6,4,2,3,5,7,0,1};
        int i = missingNumber(a);
        System.out.println(i);
    }


}
