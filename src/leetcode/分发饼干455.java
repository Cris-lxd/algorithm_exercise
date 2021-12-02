package leetcode;

import java.util.Arrays;

/**
 * leetcode
 * Date： 2021/11/25 6:23 下午
 * User： cris
 * Description：
 **/
public class 分发饼干455 {
    public static  int findContentChildren(int[] g, int[] s) {
        int[] newg = g.clone();
        int[] news = s.clone();
        int max = Integer.MAX_VALUE;
        Arrays.sort(g); Arrays.sort(s);
        int sum = 0;
        for(int i = 0; i <g.length; i++){
            for(int j = 0; j <s.length; j++){
                if(s[j] >= g[i] && g[i] != max && s[j] != max){
                    sum++;
                    g[i] = max;
                    s[j] = max;
                    break;
                }else{
                    s[j] = max;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int contentChildren = findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
