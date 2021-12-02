package leetcode;

import java.util.Stack;

/**
 * leetcode
 * Date： 2021/11/20 5:14 下午
 * User： cris
 * Description：
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 **/
public class 字符串轮换0109 {

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);

    }

    public static void main(String[] args) {
        boolean flipedString = isFlipedString("aa", "aba");
        System.out.println(flipedString);
    }
}
