package leetcode.剑指offer;

import com.sun.xml.internal.ws.binding.FeatureListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * date： 2022/5/21
 * time： 16:11
 * author： cris
 * description：
 **/
public class 二叉树中和为某一值得路径_剑指offer_34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList();
        int sum = 0;
        getTarget(new ArrayList<Integer>(), root, target);
        return res;
    }

    public static void getTarget(List<Integer> list, TreeNode root, int target) {
        if(root == null) return;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }else{
            getTarget(list,root.left,target);
            getTarget(list,root.right,target);
        }
        list.remove(list.size()-1);

    }


}
