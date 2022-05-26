package leetcode.剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * date： 2022/5/8
 * time： 10:36
 * author： cris
 * remark：
 **/
public class 第一个只出现一次的字符_剑指offer_50 {
    public static char firstUniqChar(String s) {
        char res = 0;
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num =c-'a';     //计算该字符的ASCII，确定他应该存放在数组的什么位置
            array[num] += 1;
        }
        int num = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int position =c-'a';
            if(array[position] == 1){
                num = 1;
                res = c;
                break;
            }

        }
        res = num == -1 ? ' ' : res;
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        char c = firstUniqChar(s);
        System.out.println(c);
    }
}
