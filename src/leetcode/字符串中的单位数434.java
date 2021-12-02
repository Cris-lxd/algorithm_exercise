package leetcode;

/**
 * leetcode
 * Date： 2021/11/22 8:06 下午
 * User： cris
 * Description： 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符
 **/
public class 字符串中的单位数434 {
    public static int countSegments(String s) {
        //todo 空格数加一
//        if(s.trim().equals("") || s == null) return 0;
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == ' ' && s.charAt(i-1) != ' ' && s.charAt(i+1) != ' '){
//                sum++;
//            }
//        }
//        return sum+1;
        if(s.trim().equals("") || s == null) return 0;
//        int sum = 0;
//        s = s.trim();
//        for (int i = 0; i < s.length(); i++){
//            if(!Character.isLetter(s.charAt(i))){
//                if(s.charAt(i) == ','  && i != 0){
//                    if(!Character.isLetter(s.charAt(i-1))) sum +=1;
//                }else if(s.charAt(i) == ' '){
//                    if(Character.isLetter(s.charAt(i-1)) || s.charAt(i-1) != ' '){
//                        sum +=1;
//                    }
//                }
//            }
//        }
        String[] s1 = s.split(" ");
        int num = 0;
        for (int i = 0; i < s1.length; i++) {
            String s2 = s1[i];
            if(!s1[i].equals("")){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        int sum = countSegments(s);
        System.out.println(sum);
    }
}
