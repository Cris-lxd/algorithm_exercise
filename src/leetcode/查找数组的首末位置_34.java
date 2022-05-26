package leetcode;

import java.util.Arrays;

class 查找数组的首末位置_34 {
    public static int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                start = i;
                break;
            }
        }
        if (start == -1) return new int[]{-1,-1};
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i] == target) {
                end = i;
                break;
            }
        }
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,1,2,3,3,4,5,6,6,7,8,8,8,9,9,10,10,11,11};
        int target = 0;
        int[] ints = searchRange(nums, target);
        System.out.println(ints);
    }
}