package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode
 * Date： 2021/11/29 12:10 下午
 * User： cris
 * Description： 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。  请你返回 nums 中唯一元素的 和 。
 **/
public class 唯一元素的和_1748 {
    public static int sumOfUnique(int[] nums) {
        if(nums.length == 0) return 0;
        int[] ex = new int[101];
        for (int i = 0; i < nums.length; i++) {
            ex[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < ex.length; i++) {
            if(ex[i] == 1){
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int sum = sumOfUnique(nums);
        System.out.println(sum);
    }
}
