package leetcode;

/**
 * leetcode
 * Date： 2021/12/11 5:21 下午
 * User： cris
 * Description：
 **/
public class 重新排列数组1470 {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i = 0; i < n; i++) res[2 * i] = nums[i];
        for(int i = n; i < nums.length; i++) res[2 * i - 2 * n +1] = nums[i];
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,5,1,3,4,7};
        int[] shuffle = shuffle(a, 3);
        System.out.println(shuffle);
    }
}
