package leetcode;

/**
 * leetcode
 * Date： 2021/12/12 1:06 下午
 * User： cris
 * Description：
 **/
public class 求平方根_剑指offer_072 {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == 2) return 2;
        int begin = 0;
        int end = x;
        while(end >= begin){
            int mid = (end + begin)/2 +1;
            if (x/mid < mid){
                end -= 1;
            }else if(x/mid > mid){
                begin += 1;
            }else{
                return mid;
            }
        }
        return begin;
    }
}
