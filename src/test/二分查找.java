package test;

import java.util.Arrays;

public class 二分查找 {
    public static int getAim(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else if(nums[mid] < target){
                left = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int aim = getAim(new int[]{1, 3, 5, 6, 7}, 3);
        System.out.println(aim);

    }
}
