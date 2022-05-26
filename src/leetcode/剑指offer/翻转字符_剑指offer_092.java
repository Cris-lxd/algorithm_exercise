package leetcode.剑指offer;

/**
 * leetcode
 * Date： 2021/12/11 4:02 下午
 * User： cris
 * Description：
 **/
public class 翻转字符_剑指offer_092 {
    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];
        zero[0] = s.charAt(0) == '0' ? 0 : 1;
        one[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                zero[i] = zero[i-1];
                one[i] = Math.min(one[i-1]+1,zero[i]+1);
            }else if(s.charAt(i) == '1'){
                zero[i] = zero[i-1]+1;
                one[i] =Math.min(one[i-1],zero[i-1]);
            }
        }
        return Math.min(zero[s.length()-1],one[s.length()-1]);
    }

    public static void main(String[] args) {
        int i = minFlipsMonoIncr("10011111110010111011");
        System.out.println(i);
    }
}
