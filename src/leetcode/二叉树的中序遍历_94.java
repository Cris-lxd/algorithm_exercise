package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode
 * Date： 2021/12/4 5:52 下午
 * User： cris
 * Description：
 **/
public class 二叉树的中序遍历_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List res = order(root, list);
        return res;
    }

    public static List order(TreeNode root, List<Integer> res){
        if(root == null) return null;
        order(root.left,res);
        res.add(root.val);
        order(root.right,res);
        return res;
    }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
