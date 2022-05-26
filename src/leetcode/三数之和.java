package leetcode;

import java.util.*;

/**
 * leetcode
 * Date： 2021/12/6 12:56 下午
 * User： cris
 * Description：
 **/
public class 三数之和 {

    //for循环双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int third = nums.length - 1;
                int target = -nums[i];      //后面两数相加的和
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {      //去重
                        continue;
                    }
                    while (j < third && nums[j] + nums[third] > target) {       //不满足的话c的指针向前➖1
                        third--;
                    }
                    if (j == third) {
                        break;
                    }
                    if (nums[j] + nums[i] + nums[third] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[third]));
                    }
                }
            }
        }
        return list;
    }

    //while循环双指针
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int second = i+1;
                int third = nums.length - 1;
                int target = -nums[i];      //后面两数相加的和
                while(second < third){
                    if(nums[second] + nums[third] == target){
                        list.add(Arrays.asList(nums[i],nums[second],nums[third]));
                        second++; third--; // 首先无论如何先要进行加减操作
                        while (second < third && nums[second] == nums[second - 1]) second++;
                        while (second < third && nums[third] == nums[third + 1]) third--;
                    }else if(nums[second] + nums[third] < target){
                        second++;
                    }else if(nums[second] + nums[third] > target){
                        third--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = threeSum1(new int[]{-1, -1, 0, 1, 2, -4});

    }


    
}
