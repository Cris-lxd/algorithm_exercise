package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * test
 * Date： 2021/11/7 5:43 下午
 * User： cris
 * Description： 测试
 **/
public class test {

    public static int previous(int[][] task,int num){
        int previousTask = 0;
        int max = 0;
        int val = task[num][1];
        for (int i = 0; i < task.length; i++) {
            if(task[i][1] < val){
                if(task[i][1] > max){
                    max = task[i][1];
                    previousTask = i;
                }
            }
        }
        return previousTask;
    }


    public static int getMoney(int[][] task,int[] memo,int num){
        int max = 0;
        if(num == 0){
            return 0;
        }
        int[] dp = new int[task.length];
        if(memo[num] != 0){
            return memo[num];
        }else {
            dp[num] = Math.max(getMoney(task, memo, num - 1), getMoney(task, memo, previous(task, num))+task[num][1]);
            memo[num] = dp[num];
            return dp[num];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; ++i) {
            System.out.println(i);
        }
    }
}
