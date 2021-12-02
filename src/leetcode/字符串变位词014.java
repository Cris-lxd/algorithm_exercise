package leetcode;

import java.util.Arrays;

/**
 * leetcode
 * Date： 2021/11/26 3:46 下午
 * User： cris
 * Description： 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串
 *
 **/
public class 字符串变位词014 {

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        if(s2.contains(s1)) return true;
        int[] nums1 = new int[26];
        //统计s1中的字符
        for (int i = 0; i < s1.length(); i++) {
            int ascii = s1.charAt(i) - 'a';
            nums1[ascii]++;
        }
        //滑动窗口，挨个数n个数字放到nums2中
        int i = 0;
        while(s2.length() - i >= s1.length()){
            int[] nums2 = new int[26];
            for (int j = i; j < s2.length(); j++) {
                if(j - i >= s1.length()) break;
                int ascii = s2.charAt(j) - 'a';
                nums2[ascii]++;
            }
            if(Arrays.equals(nums1,nums2)){
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }
}
