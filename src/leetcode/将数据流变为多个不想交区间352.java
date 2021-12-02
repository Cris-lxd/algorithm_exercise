package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * git
 * Date： 2021/11/7 5:21 下午
 * User： cris
 * Description： 352. 将数据流变为多个不相交区间
 **/
public class 将数据流变为多个不想交区间352 {
    List<Integer> list;
    public 将数据流变为多个不想交区间352() {
        list = new ArrayList();
    }

    public void addNum(int val) {
        list.add(val);
    }

    public int[][] getIntervals() {
        if(list.size()==1){return new int[][]{{list.get(0),list.get(0)}};}
        Collections.sort(list);
        List<int[]> intevals=new ArrayList<>();
        int l=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)>1){
                intevals.add(new int[]{l,list.get(i-1)});
                l=list.get(i);
            }
        }
        intevals.add(new int[]{l,list.get(list.size()-1)});
        return intevals.toArray(new int[intevals.size()][]);
    }

    public static void main(String[] args) {
        将数据流变为多个不想交区间352 obj = new 将数据流变为多个不想交区间352();
        obj.addNum(6);
        int[][] parm2 = obj.getIntervals();
        obj.addNum(6);
        int[][] parm3 = obj.getIntervals();
        obj.addNum(0);
        int[][] parm4 = obj.getIntervals();
        obj.addNum(4);
        int[][] parm5 = obj.getIntervals();
        obj.addNum(8);
        int[][] parm6 = obj.getIntervals();
        obj.addNum(7);
        int[][] parm7 = obj.getIntervals();
        obj.addNum(6);
        int[][] parm8 = obj.getIntervals();
        obj.addNum(4);
        int[][] parm9 = obj.getIntervals();
        obj.addNum(7);
        int[][] parm10 = obj.getIntervals();
        obj.addNum(5);
        int[][] parm11 = obj.getIntervals();
        System.out.println("q");

    }
}
