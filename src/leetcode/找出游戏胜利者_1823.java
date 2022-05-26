package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * date： 2022/5/4
 * time： 14:43
 * author： cris
 * remark：
 **/
public class 找出游戏胜利者_1823 {
    public static int findTheWinner(int n, int k) {
        List list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        List num = getNum(list, 0, k);
        return (int)list.get(0);
    }

    public static  List getNum(List list,int start,int k){
        if(list.size() == 1) return list;
        int end = start + k -1;
        if(end >= list.size()){
            end = end % list.size();
            list.remove(list.get(end));
        }else{
            list.remove(list.get(end));
        }
        List list1 = getNum(list,end,k);
        return list;
    }

    public static void main(String[] args) {
        int theWinner = findTheWinner(6, 5);
        System.out.println(theWinner);
    }
}
