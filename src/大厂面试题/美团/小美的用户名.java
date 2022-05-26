package 大厂面试题.美团;

import java.util.Scanner;

/**
 * date： 2022/2/19
 * time： 12:19 PM
 * author： cris
 * remark：小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，一个合法的用户名必须满足以下几个要求：
 *          1.用户名的首字符必须是大写或者小写字母。
 *          2.用户名只能包含大小写字母，数字。
 *          3.用户名需要包含至少一个字母和一个数字。
 *          4.如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 *
 * 作者：美团
 * 链接：https://leetcode-cn.com/leetbook/read/meituan/ohsjgd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class 小美的用户名 {

    public static void checkUsername(String username){
        int letter = 0;
        int num = 0;
        if(Character.isUpperCase(username.charAt(0)) || Character.isLowerCase(username.charAt(0))){
            for (int i = 0; i < username.length(); i++) {
                if(!Character.isDigit(username.charAt(i)) && !Character.isLetter(username.charAt(i))){
                    System.out.println("Wrong");
                    return;
                }
                letter = Character.isLetter(username.charAt(i)) == true ? letter+1 : letter;
                num = Character.isDigit(username.charAt(i)) == true ? num+1 : num;
            }
            if(letter == 0 || num == 0){
                System.out.println("Wrong");
                return;
            }
            System.out.println("Accept");

        }else{
            System.out.println("Wrong");
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            checkUsername(username);
        }

    }
}
