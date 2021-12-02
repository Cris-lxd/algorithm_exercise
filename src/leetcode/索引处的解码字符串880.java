package leetcode;

/**
 * leetcode
 * Date： 2021/11/12 5:16 下午
 * User： cris
 * Description：880.索引处的解码字符串
 *  给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 *  1.如果所读的字符是字母，则将该字母写在磁带上。
 *  2.如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 *  现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 **/
public class 索引处的解码字符串880 {

    public static String decodeAtIndex(String s, int k) {
        //先遍历如果是纯字母的话  则返回相应位置的字母
        if(k <= s.length()) {
            int sign = 0;
            for (int i = 0; i < k; i++) {
                if (Character.isDigit(s.charAt(i))) {
                    sign++;
                    break;
                }
            }
            if (sign == 0) return String.valueOf(s.charAt(k - 1));     //如果是0代表字符串没有含有数字，则直接返回对应字母
        }
        
        String res = "";
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))){
                res+=s.charAt(i);        //如果不为字符串则拼接上去该位置的字符
            }else{
                char a = s.charAt(i);
                int n = a-'0'-1;      //ASCII值 - '0'的ASCII值
                String temp = res.toString();
                for (int j = 0; j < n; j++) {
                    res+=temp;
                }
                res+=s.substring(i+1);
                result = decodeAtIndex(res.toString(),k);
                break;
            }
        }
        return result;

//        return null;
    }

    public static void main(String[] args) {
//        String hahaha = decodeAtIndex("vzpp636m8y", 2920);
//        System.out.println(hahaha);
        String leet2code3 = decodeAtIndex2("a2345678999999999999999", 1);
        System.out.println(leet2code3);
    }


    public static String decodeAtIndex2(String s, int k) {
        long length = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                char a = s.charAt(i);
                int n = a-'0';
                length*=n;
            }else{
                length+=1;
            }
        }
        for (int i = s.length()-1; i >=0; i--) {
            char a = s.charAt(i);
            k %= length;
            if(k == 0 && Character.isLetter(a)){
                return String.valueOf(a);
            }
            if(Character.isDigit(a)){
                int n = a-'0';
                length /= n;
            }else {
                length--;
            }


        }
        return null;
    }
}
