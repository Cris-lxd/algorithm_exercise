package leetcode;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * date： 2022/3/9
 * time： 7:50 PM
 * author： cris
 * remark：一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
 *          我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
 *
 **/
public class 将句子排序_1859 {

    public static  String sortSentence(String s) {
        if(s == null || "".equals(s)){
            return "";
        }
        s = s.trim();
        String[] aArray = new String[10];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)) == true){
                int num = Character.getNumericValue(s.charAt(i));
                aArray[num] = s.substring(start, i);
                start = i + 2;
            }
        }
        String res = "";
        for (int i = 0; i < aArray.length; i++) {
            if(aArray[i] != null && aArray[i] != "" && "".equals("")){
                res += (aArray[i] + " ");
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        String myself2_me1_i4_and3 = sortSentence("is2 sentence4 This1 a3");
        System.out.println(myself2_me1_i4_and3);
    }
}
