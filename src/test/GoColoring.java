package test;

import java.util.ArrayList;
import java.util.List;

/**
 * date： 2022/5/6
 * time： 21:15
 * author： cris
 * remark：
 **/
public class GoColoring {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public static int coloring(TreeNode root, int times, int n, List list) {     //n表示第几层(1) ， sign表示第几次(0)
        if(n == (int)list.get(0)){  //判断当前是否为2，5，8，...层
            list.remove(list.get(0));
            times++;        //次数加1
            n++;            //层数加1
        }
        if(root.left != null) {
            times = coloring(root.left, times, n, list);
        }else if((n == (int)list.get(0) - 1) && root.left == null){//判断是否为2，5，8层减一层即波及不到的层{
            times++;
        }
        if(root.right != null) {
            times = coloring(root.right, times, n, list);
        }else if((n == (int)list.get(0) - 1) && root.right == null){//判断是否为2，5，8层减一层即波及不到的层{
            times++;
        }
        return times;


    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(3*i-1);
        }
        int times = coloring(new TreeNode(), 0, 1, list);
        System.out.println(times);
    }


}
